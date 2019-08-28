package com.example.RestFileApi;

import com.example.RestFileApi.service.FileImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @Value("${files.path}")
    private String destination;

    private final static Logger log = LoggerFactory.getLogger(FileImpl.class);

    @RequestMapping("/files/{fileId}")
    public ResponseEntity<Object> getFile(@PathVariable("fileId")int fileId) {
        log.info("File name is :" + fileId);
        FileImpl file = new FileImpl();
        ResponseEntity<Object> response = file.downloadFile(fileId, destination);
        return response;
    }
}