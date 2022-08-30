package com.extremecoder.fileservice.repository;

import com.extremecoder.fileservice.enums.ActiveStatus;
import com.extremecoder.fileservice.model.FileInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class FileInfoRepositoryIntegrationTest {

    @Autowired
    private FileInfoRepository fileInfoRepository;

    private FileInfo file1;

    private FileInfo file2;

    @BeforeEach
    void setup() {
        file1 = FileInfo.builder()
                .fileName("image_1")
                .filePath("D:/ExtremeCoder")
                .fileType("image")
                .extension("jpg")
                .originalFilename("flower_image")
                .size(100).build();

        file2 = FileInfo.builder()
                .fileName("doc_1")
                .filePath("D:/ExtremeCoder")
                .fileType("document")
                .extension("doc")
                .originalFilename("Doc_file")
                .size(50).build();
    }

    @Test
    @DisplayName("Test for saving a file")
    void saveFile() {
        Long saved_fileInfoId = fileInfoRepository.save(file1).getFileId();
        assertNotNull(saved_fileInfoId);
        assertTrue(saved_fileInfoId > 0);
        tearDown(Collections.singletonList(saved_fileInfoId));
    }

    @Test
    @DisplayName("Test for saving multiple file")
    void save_multipleFile() {
        List<Long> saved_fileInfoIds = fileInfoRepository.saveAll(Arrays.asList(file1, file2)).stream()
                .map(FileInfo::getFileId).collect(Collectors.toList());
        assertFalse(saved_fileInfoIds.isEmpty());
        assertEquals(saved_fileInfoIds.size(), 2);
        tearDown(saved_fileInfoIds);
    }

    @Test
    @DisplayName("Test for retrieving a file by ID")
    void getFileById() {
        Long savedId = fileInfoRepository.save(file1).getFileId();
        Optional<FileInfo> result = fileInfoRepository.findById(savedId);
        assertFalse(result.isEmpty());
        assertEquals(result.get().getFileId(), savedId);
        tearDown(Collections.singletonList(savedId));
    }

    @Test
    @DisplayName("Test for retrieving all files")
    void getAllFiles() {
        List<Long> savedIds = fileInfoRepository.saveAll(Arrays.asList(file1, file2)).stream()
                .map(FileInfo::getFileId).collect(Collectors.toList());
        List<Long> retrievedFilesIds = fileInfoRepository.findAll().stream()
                .map(FileInfo::getFileId).collect(Collectors.toList());
        assertFalse(retrievedFilesIds.isEmpty());
        tearDown(savedIds);
    }

    @Test
    @DisplayName("Test custom delete method")
    void deleteFile() {
        file1.setActiveStatus(ActiveStatus.ACTIVE);
        FileInfo savedFile = fileInfoRepository.save(file1);
        fileInfoRepository.delete(savedFile);
        ActiveStatus fileStatus = fileInfoRepository.findById(savedFile.getFileId()).get().getActiveStatus();
        assertEquals(ActiveStatus.DELETED, fileStatus);
        tearDown(Collections.singletonList(savedFile.getFileId()));
    }

    void tearDown(List<Long> ids) {
        fileInfoRepository.deleteAllById(ids);
    }
}
