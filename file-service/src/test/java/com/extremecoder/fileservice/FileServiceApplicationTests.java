package com.extremecoder.fileservice;

import com.extremecoder.fileservice.service.FileStorageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

@SpringBootTest
class FileServiceApplicationTests {

    @Autowired
    FileStorageService fileStorageService;

    @Test
    void storeFileTest() {
        MockMultipartFile multipartFile =
                new MockMultipartFile("springboot.png", "springboot.png", "image/png",
                        "".getBytes());

        fileStorageService.storeFile(multipartFile);
    }

}
