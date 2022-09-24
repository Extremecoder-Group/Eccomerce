package com.extremecoder.productservice.repository;

import com.extremecoder.productservice.enums.ActiveStatus;
import com.extremecoder.productservice.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Override
    default void delete(Brand entity) {
        entity.setActiveStatus(ActiveStatus.DELETED);
        save(entity);
    }
}
