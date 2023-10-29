package com.example.nasapicdownloadversion.service;

import com.example.nasapicdownloadversion.utils.Utils;
import org.apache.http.client.methods.HttpGet;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PictureDownloaderService {

    HttpGet request = new HttpGet(
            "https://api.nasa.gov/planetary/apod?api_key=KwNhupDYakuFL47wX9An8R1YRVHfWGCts70zcfkX");

    public Resource downloadPicture() throws IOException {
        return new UrlResource(Utils.getUrl(request));
    }
}

