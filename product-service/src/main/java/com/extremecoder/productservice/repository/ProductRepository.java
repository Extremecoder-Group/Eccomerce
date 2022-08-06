package com.extremecoder.productservice.repository;

import com.extremecoder.productservice.enums.ActiveStatus;
import com.extremecoder.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    default void delete(Product entity) {
        entity.setActiveStatus(ActiveStatus.DELETED);
        save(entity);
    }
}
