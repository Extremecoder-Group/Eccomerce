package com.extremecoder.productservice.repository;

import com.extremecoder.productservice.enums.ActiveStatus;
import com.extremecoder.productservice.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    @Override
    default void delete(CategoryEntity entity) {
        entity.setActiveStatus(ActiveStatus.DELETED);
        save(entity);
    }
}
