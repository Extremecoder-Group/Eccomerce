package com.extremecoder.productservice.repository;

import com.extremecoder.productservice.enums.ActiveStatus;
import com.extremecoder.productservice.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    @Override
    default void delete(CategoryEntity entity) {
        entity.setActiveStatus(ActiveStatus.DELETED);
        save(entity);
    }

    @Query("select C from CategoryEntity C where C.id = :id " +
            "and C.activeStatus = com.extremecoder.productservice.enums.ActiveStatus.ACTIVE")
    CategoryEntity findByIdAndActiveStatus_Active(Long id);

    @Query("select C from CategoryEntity C " +
            "where C.activeStatus = com.extremecoder.productservice.enums.ActiveStatus.ACTIVE")
    List<CategoryEntity> findAllByActiveStatus_Active();
}
