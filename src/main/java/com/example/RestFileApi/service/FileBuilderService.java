package com.example.RestFileApi.service;


import org.springframework.http.ResponseEntity;


interface FileBuilder {
    ResponseEntity<Object> downloadFile(String name, String destination);
}
