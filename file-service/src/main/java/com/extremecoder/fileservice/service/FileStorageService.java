package com.extremecoder.fileservice.service;

import com.extremecoder.fileservice.model.FileInfo;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileStorageService {
    FileInfo storeFile(MultipartFile file);
    List<FileInfo> uploadMultipleFiles(MultipartFile[] files);
    Resource loadFileAsResource(Long fileId);
}
