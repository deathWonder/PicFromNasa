package com.example.nasapicdownloadversion.controller;

import com.example.nasapicdownloadversion.service.PictureDownloaderService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/nasaPicture")
public class DownloaderController {

    private final PictureDownloaderService service;

    public DownloaderController(PictureDownloaderService service) {
        this.service = service;
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> download() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(service.downloadPicture(), headers, HttpStatus.OK);

    }
}
