package com.extremecoder.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product extends BaseEntity {
    @Id
    @GeneratedValue
    private Long productId;

    @Column(nullable = false)
    private String name;

    @Column(length = 2000, nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(name="imageId", nullable = true)
    private ImageInformation image;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = true)
    private Category category;
}
