package com.example.RestFileApi;

import com.example.RestFileApi.service.FileImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @Value("${files.path}")
    private String destination;

    @RequestMapping("/files/{fileId}")
    public ResponseEntity<Object> getFile(@PathVariable("fileId")int fileId) {
        FileImpl file = new FileImpl();
        ResponseEntity<Object> response = file.downloadFile(fileId, destination);
        return response;
    }
}