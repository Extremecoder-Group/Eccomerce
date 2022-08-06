package com.extremecoder.productservice.repository;

import com.extremecoder.productservice.enums.ActiveStatus;
import com.extremecoder.productservice.model.ImageInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageInfoRepository extends JpaRepository<ImageInformation, Long> {

    @Override
    default void delete(ImageInformation entity) {
        entity.setActiveStatus(ActiveStatus.DELETED);
        save(entity);
    }
}
