package com.extremecoder.fileservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileInfo extends BaseEntity {

    @Id
    @GeneratedValue
    private Long fileId;

    private String fileName;
    private String originalFilename;
    private String filePath;
    private String fileType;
    private String extension;
    private long size;
}
