package com.extremecoder.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    private String description;

    @Column(name = "is_parent", nullable = false)
    private Boolean isParent = Boolean.TRUE;

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
