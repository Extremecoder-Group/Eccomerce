package com.extremecoder.fileservice.service.impl;

import com.extremecoder.fileservice.config.FileStorageProperties;
import com.extremecoder.fileservice.constant.FileConstant;
import com.extremecoder.fileservice.exception.FileStorageException;
import com.extremecoder.fileservice.exception.MyFileNotFoundException;
import com.extremecoder.fileservice.model.FileInfo;
import com.extremecoder.fileservice.repository.FileInfoRepository;
import com.extremecoder.fileservice.service.FileStorageService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    private final FileInfoRepository fileInfoRepository;
    private final Path fileStorageLocation;

    @Autowired
    public FileStorageServiceImpl(FileInfoRepository fileInfoRepository, FileStorageProperties fileStorageProperties) {
        this.fileInfoRepository = fileInfoRepository;
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public FileInfo storeFile(MultipartFile file) {
        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if(originalFilename.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + originalFilename);
            }
            String extension = FilenameUtils.getExtension(originalFilename);
            UUID uuid = UUID.randomUUID();
            String fileName = new StringBuilder()
                    .append(uuid.toString())
                    .append(FileConstant.DOT)
                    .append(extension).toString();

            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            FileInfo fileInfo = FileInfo.builder()
                    .filePath(FileConstant.DOWNLOAD_FILE_END_POINT)
                    .originalFilename(originalFilename)
                    .extension(extension)
                    .fileType(file.getContentType())
                    .fileName(fileName)
                    .size(file.getSize())
                    .build();
            fileInfo = fileInfoRepository.save(fileInfo);
            fileInfo.setFilePath(
                    new StringBuilder()
                            .append(fileInfo.getFilePath())
                            .append(fileInfo.getFileId()).toString()
            );
            fileInfo = fileInfoRepository.save(fileInfo);
            return fileInfo;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + originalFilename + ". Please try again!", ex);
        }
    }

    @Override
    public List<FileInfo> uploadMultipleFiles(MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> storeFile(file))
                .collect(Collectors.toList());
    }

    public Resource loadFileAsResource(Long fileId) {
        try {
            Optional<FileInfo> fileInfoOptional = fileInfoRepository.findById(fileId);
            if(fileInfoOptional.isEmpty()) {
                throw new MyFileNotFoundException("File not found with Id: " + fileId);
            }
            Path filePath = this.fileStorageLocation.resolve(fileInfoOptional.get().getFileName()).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found with Id: " + fileId);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found with Id: " + fileId, ex);
        }
    }
}
