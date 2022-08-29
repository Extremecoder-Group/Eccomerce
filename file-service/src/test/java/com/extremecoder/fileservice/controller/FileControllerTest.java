package com.extremecoder.fileservice.controller;

import com.extremecoder.fileservice.model.FileInfo;
import com.extremecoder.fileservice.service.FileStorageService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * File Controller Test
 *
 * @author Badrul
 */

@Slf4j
@ExtendWith(MockitoExtension.class)
class FileControllerTest {

    @InjectMocks
    FileController fileController;

    @Mock
    FileStorageService fileStorageService;

    @BeforeAll
    static void beforeAll() {
        log.info("*** FileControllerTest.beforeAll()***");
    }

    @Test
    @DisplayName("when uploadFile() is called then upload single file")
    void uploadFile() {
        log.info("*** FileControllerTest.uploadFile() -- started -- ***");

        String fileName = "sampleFile.txt";

        MockMultipartFile sampleFile = new MockMultipartFile(
                "uploaded-file",
                fileName,
                "text/plain",
                "This is the file content".getBytes()
        );

        FileInfo fileInfo = FileInfo.builder()
                .fileName(fileName)
                .originalFilename(fileName)
                .build();

        log.info("Original fileName: " + fileInfo.getOriginalFilename());

        when(fileStorageService.storeFile(sampleFile)).thenReturn(fileInfo);

        FileInfo fileInfoResponse = fileController.uploadFile(sampleFile);

        assertEquals(fileInfo.getOriginalFilename(), fileInfoResponse.getOriginalFilename());

        log.info("*** FileControllerTest.uploadFile() -- ended -- ***");

    }

    @Test
    void uploadMultipleFiles() {
    }

    @Test
    void downloadFile() {
    }
}