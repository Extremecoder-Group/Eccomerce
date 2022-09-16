package com.extremecoder.productservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BaseEntity {
    @Id
    @GeneratedValue
    private Long categoryId;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "imageId")
    private ImageInformation image;

    @ManyToOne
    @JoinColumn(name = "parentCategory")
    private Category parentCategory;
}
