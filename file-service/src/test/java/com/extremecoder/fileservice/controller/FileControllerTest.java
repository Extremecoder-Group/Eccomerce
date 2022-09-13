package com.extremecoder.fileservice.controller;

import com.extremecoder.fileservice.model.FileInfo;
import com.extremecoder.fileservice.service.FileStorageService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * File Controller Test
 *
 * @author Badrul
 */

@ExtendWith(MockitoExtension.class)
class FileControllerTest {

    @InjectMocks
    FileController fileController;

    @Mock
    FileStorageService fileStorageService;

    static MockMultipartFile sampleFile1;

    static MockMultipartFile sampleFile2;

    static String fileName1 = "sampleFile1.txt";
    static String fileName2 = "sampleFile2.txt";

    @BeforeAll
    static void beforeAll() {

        sampleFile1 = new MockMultipartFile(fileName1, fileName1, "text/plain", "Hello World! from 1".getBytes());

        sampleFile2 = new MockMultipartFile(fileName2, fileName2, "text/plain", "Hello World! from 2".getBytes());

    }

    @Test
    @DisplayName("when uploadFile() is called then upload single file")
    void uploadFile() {

        // Arrange
        FileInfo fileInfo = FileInfo.builder().fileName(fileName1).originalFilename(fileName1).build();

        // Act
        when(fileStorageService.storeFile(sampleFile1)).thenReturn(fileInfo);

        // Assert
        FileInfo fileInfoResponse = fileController.uploadFile(sampleFile1);

        assertEquals(fileInfo.getOriginalFilename(), fileInfoResponse.getOriginalFilename());

    }

    @Test
    @DisplayName("when uploadMultipleFiles() is called then upload multiple files")
    void uploadMultipleFiles() {

        List<FileInfo> fileInfos = List.of(
                FileInfo.builder()
                        .fileName(fileName1)
                        .originalFilename(fileName1)
                        .build(),
                FileInfo.builder().
                        fileName(fileName2)
                        .originalFilename(fileName2)
                        .build());

        MultipartFile[] multipartFile = new MultipartFile[]{sampleFile1, sampleFile2};

        when(fileStorageService.uploadMultipleFiles(multipartFile))
                .thenReturn(fileInfos);

        List<FileInfo> fileInfosResponse = fileController.uploadMultipleFiles(multipartFile);


        List<String> responseFileNames = fileInfosResponse
                .stream().map(FileInfo::getOriginalFilename)
                .collect(Collectors.toList()).stream().sorted()
                .collect(Collectors.toList());


        List<String> fileNames = fileInfos
                .stream().map(FileInfo::getOriginalFilename)
                .collect(Collectors.toList()).stream().sorted()
                .collect(Collectors.toList());


        assertEquals(fileNames, responseFileNames);
    }

    @Test
    void downloadFile() {
    }
}