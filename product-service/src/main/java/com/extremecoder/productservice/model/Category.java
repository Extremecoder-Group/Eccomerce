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
public class Category extends BaseEntity {
    @Id
    @GeneratedValue
    private Long categoryId;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="imageId", nullable = true)
    private ImageInformation image;

    @ManyToOne
    @JoinColumn(name = "parentCategory", nullable = true)
    private Category parentCategory;
}
