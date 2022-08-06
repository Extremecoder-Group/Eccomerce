package com.extremecoder.fileservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/image")
public class ImageController {

    @GetMapping("/")
    public String dummy() {
        return "dummary String";
    }

}
