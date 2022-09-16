package com.extremecoder.fileservice.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
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
