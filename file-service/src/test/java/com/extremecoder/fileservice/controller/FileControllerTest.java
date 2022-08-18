package com.extremecoder.fileservice.controller;

import com.extremecoder.fileservice.service.FileStorageService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * File Controller Test
 *
 * @author Badrul
 */
@Slf4j
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class FileControllerTest {

    @InjectMocks
    FileController fileController;
    @Mock
    FileStorageService fileStorageService;

    @Autowired
    MockMvc mockMvc;


    @BeforeAll
    static void beforeAll() {
        log.info("*** FileControllerTest.beforeAll()***");
    }

    @Test
    @DisplayName("upload single file")
    void uploadFile() throws Exception {
//
//        FileInputStream fis = new FileInputStream("E:\\New folder\\Ancillary Services(1).jpg");
//
//        MockMultipartFile multipartFile = new MockMultipartFile("file", fis);
//
//        FileInfo fileInfo = fileController.uploadFile(multipartFile);

//        FileInfo fileInfo = fileController.uploadFile(file);

        String fileName = "sampleFile.txt";
        MockMultipartFile sampleFile = new MockMultipartFile(
                "uploaded-file",
                fileName,
                "text/plain",
                "This is the file content".getBytes()
        );

        MockMultipartHttpServletRequestBuilder multipartRequest =
                MockMvcRequestBuilders.multipart("/uploadFile");

        mockMvc.perform(multipartRequest.file(sampleFile))
                .andExpect(status().isOk());
//
//        Path docRootPath = Path.of(documentRoot, fileName);
//        filesToBeDeleted.add(docRootPath);
//        assertThat(Files.exists(docRootPath)).isTrue();

        System.out.println(234);

    }

    @Test
    @DisplayName("Test API")
    void test() {
        assertEquals("Hello World!", fileController.test());
    }


    @Test
    void uploadMultipleFiles() {
    }

    @Test
    void downloadFile() {
    }
}