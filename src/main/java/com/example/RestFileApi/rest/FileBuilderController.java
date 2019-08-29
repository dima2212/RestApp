package com.example.RestFileApi.rest;

import com.example.RestFileApi.service.FileBuilderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@RestController
public class FileController {


    @Autowired
    private FileBuilderServiceImpl file;

    private final static Logger log = LoggerFactory.getLogger(FileBuilderServiceImpl.class);

    @RequestMapping("/files/file/{name}")
    public ResponseEntity<Object> getFile(@PathVariable("name") @NotBlank @Size(max = 10) String name) {
        log.info("File name is {} :",name);
        ResponseEntity<Object> response = file.downloadFile(name);
        return response;
    }
}