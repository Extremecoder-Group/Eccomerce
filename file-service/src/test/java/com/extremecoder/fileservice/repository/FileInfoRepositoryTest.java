package com.extremecoder.fileservice.repository;

import com.extremecoder.fileservice.model.FileInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
public class FileInfoRepositoryTest {

    @Autowired
    FileInfoRepository fileInfoRepository;

    @Test
    @DisplayName("Test for saving a file")
    public void saveFile() {
        FileInfo fileInfo = fileInfoRepository.save(FileInfo.builder()
                .fileName("Hello")
                .filePath("D:/ExtremeCoder")
                .fileType("image")
                .extension("jpg")
                .originalFilename("1234hdg")
                .size(2)
                .build());
        assertTrue(fileInfo.getFileId() > 0);
    }

}
