package com.extremecoder.fileservice.repository;

import com.extremecoder.fileservice.enums.ActiveStatus;
import com.extremecoder.fileservice.model.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {

    @Override
    default void delete(FileInfo entity) {
        entity.setActiveStatus(ActiveStatus.DELETED);
        save(entity);
    }
}
