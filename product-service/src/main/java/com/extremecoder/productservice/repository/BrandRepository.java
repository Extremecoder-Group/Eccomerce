package com.extremecoder.productservice.repository;

import com.extremecoder.productservice.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import static com.extremecoder.productservice.enums.ActiveStatus.DELETED;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Override
    default void delete(Brand entity) {
        entity.setActiveStatus(DELETED);
        save(entity);
    }
}
