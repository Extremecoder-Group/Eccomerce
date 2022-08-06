package com.extremecoder.productservice.repository;

import com.extremecoder.productservice.enums.ActiveStatus;
import com.extremecoder.productservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Override
    default void delete(Category entity) {
        entity.setActiveStatus(ActiveStatus.DELETED);
        save(entity);
    }
}
