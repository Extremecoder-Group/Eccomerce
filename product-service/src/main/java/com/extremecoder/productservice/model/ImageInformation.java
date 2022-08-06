package com.extremecoder.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageInformation extends BaseEntity {
    @Id
    @GeneratedValue
    private Long imageInfoId;

    @Column(nullable = false)
    private Long defaultImageId;

    @Column(nullable = false)
    private String imageIds;
}
