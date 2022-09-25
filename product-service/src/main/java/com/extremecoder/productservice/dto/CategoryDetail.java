package com.extremecoder.productservice.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
public class CategoryDetail {
    private Long id;

    private String name;

    private String description;

    private Boolean isParent;

    private ParentCategory parentCategory;

    private Date createdDate;

    private Date lastModifiedDate;

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ParentCategory {
        public Long id;
        public String name;
        private String description;
    }


}
