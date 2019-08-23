package com.example.RestFileApi.service;


import org.springframework.http.ResponseEntity;


interface FileInterface {
    ResponseEntity<Object> downloadFile(int fileId, String destination);
}
