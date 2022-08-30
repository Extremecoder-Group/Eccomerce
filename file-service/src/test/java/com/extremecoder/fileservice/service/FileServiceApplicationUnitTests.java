package com.extremecoder.fileservice.service;

import com.extremecoder.fileservice.exception.FileStorageException;
import com.extremecoder.fileservice.exception.MyFileNotFoundException;
import com.extremecoder.fileservice.model.FileInfo;
import com.extremecoder.fileservice.repository.FileInfoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class FileServiceApplicationUnitTests {

    static MockMultipartFile sampleTextFile;
    static MockMultipartFile sampleImage;
    static MockMultipartFile invalidFile1;
    static String fileName1 = "sampleFile1.txt";
    static String invalidFileName = "invalid..png";

    /*InjectMocks is not working*/
    @Autowired
    FileStorageService fileStorageService;
    /*Mock is not working*/
    @MockBean
    FileInfoRepository fileInfoRepository;

    @BeforeAll
    static void setUp() {
        sampleTextFile = new MockMultipartFile(fileName1, fileName1, "text/plain", "file-one".getBytes());
        invalidFile1 = new MockMultipartFile(invalidFileName, invalidFileName, "image/png", "".getBytes());
    }


    @Test
    @DisplayName("Expected Exception while filename contains invalid path sequence ")
    void fileStorageExceptionTest() {

        FileStorageException thrown = Assertions.assertThrows(FileStorageException.class,
                () -> fileStorageService.storeFile(invalidFile1), "FileStorageException Expected");

        Assertions.assertEquals("Sorry! Filename contains invalid path sequence " +
                invalidFile1.getOriginalFilename(), thrown.getMessage());
    }

    /*//TODO
    void storeFileIOException(){

    }*/

    @Test
    @DisplayName("File StoreFile Test")
    void storeFileTest() {

        FileInfo fileInfo = FileInfo.builder().fileName(fileName1).originalFilename(fileName1)
                .fileType("text/plain").build();

        when(fileInfoRepository.save(any())).thenReturn(fileInfo);

        FileInfo fileInfoResponse = fileStorageService.storeFile(sampleTextFile);
        assertAll("Verify all values return as response",
                () -> assertEquals(fileInfo.getOriginalFilename(), fileInfoResponse.getOriginalFilename()),
                () -> assertEquals("text/plain", fileInfoResponse.getFileType())
        );
    }

    @Test
    @DisplayName("When File is empty at DB")
    void loadFileAsResourceMyFileNotFoundExceptionTest() {
        Long demoId = 1L;
        when(fileInfoRepository.findById(any())).thenReturn(Optional.empty());
        MyFileNotFoundException fileNotFoundException = assertThrows(MyFileNotFoundException.class, () ->
                fileStorageService.loadFileAsResource(demoId));
        assertEquals("File not found with Id: " + demoId, fileNotFoundException.getMessage());
    }

    @Test
    @DisplayName("When Resource is not present at server")
    void resourceIsNotPresentAtServerLocationUrl() {

        Optional<FileInfo> fileInfo = Optional.ofNullable(FileInfo.builder().fileName(fileName1).originalFilename(fileName1)
                .fileType("text/plain").build());
        Long demoId = 1L;
        when(fileInfoRepository.findById(any())).thenReturn(fileInfo);

        MyFileNotFoundException fileNotFoundException = assertThrows(MyFileNotFoundException.class, () ->
                fileStorageService.loadFileAsResource(demoId));

        assertEquals("File not found with Id: " + demoId, fileNotFoundException.getMessage());
    }

    /*//TODO
    void resourcePresent() {

    }*/

   /* //TODO
    @Test
    void uploadMultipleFilesTest() {

    }*/

}
