package com.example.nasapicdownloadversion.utils;

import com.example.nasapicdownloadversion.model.NasaObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class Utils {

    private final static CloseableHttpClient httpClient = HttpClientBuilder.create()
            .setDefaultRequestConfig(RequestConfig.custom()
                    .setConnectTimeout(5000)    // максимальное время ожидание подключения к серверу
                    .setSocketTimeout(30000)    // максимальное время ожидания получения данных
                    .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                    .build())
            .build();

    private final static ObjectMapper mapper = new ObjectMapper();

    public static String getUrl(HttpGet uri) throws IOException {

        CloseableHttpResponse response = httpClient.execute(uri);
        NasaObject nasaObject = mapper.readValue(response.getEntity().getContent(), NasaObject.class);
        return nasaObject.getHdurl();
//      Если захочу загрузить фотографии
//        CloseableHttpResponse responsePic = httpClient.execute(new HttpGet(HDUrl));
//        byte[] bytes = responsePic.getEntity()
//                .getContent()
//                .readAllBytes();
//
//
//        response.close();
//        responsePic.close();
//        httpClient.close();
//
//
//        try (FileOutputStream out = new FileOutputStream(nasaObject.getTitle() + ".jpg");
//             BufferedOutputStream bos = new BufferedOutputStream(out)) {
//            bos.write(bytes, 0, bytes.length);
//        } catch (IOException exception) {
//            System.out.println(exception.getMessage());
//        }
    }
}
