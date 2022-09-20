package com.extremecoder.productservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Boolean isParent;

    //    @ManyToOne
//    @JoinColumn(name = "parentCategory")
//    private Category parentCategory;


//    @Column(nullable = false)
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "imageId")
//    private ImageInformation image;
//
//    @ManyToOne
//    @JoinColumn(name = "parentCategory")
//    private Category parentCategory;
}
