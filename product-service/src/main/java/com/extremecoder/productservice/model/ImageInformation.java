package com.extremecoder.productservice.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class ImageInformation extends BaseEntity {
    @Id
    @GeneratedValue
    private Long imageInfoId;

    @Column(nullable = false)
    private Long defaultImageId;

    @Column(nullable = false)
    private String imageIds;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ImageInformation that = (ImageInformation) o;
        return imageInfoId != null && Objects.equals(imageInfoId, that.imageInfoId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
