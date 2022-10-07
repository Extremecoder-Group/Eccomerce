package com.extremecoder.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDetail {
    private Long id;

    private String name;

    private String description;

    private Boolean isParent;

    private ParentCategoryDetail parentCategory;

    private Date createdDate;

    private Date lastModifiedDate;

}
