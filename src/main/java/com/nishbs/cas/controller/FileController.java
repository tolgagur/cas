package com.nishbs.cas.controller;

import com.nishbs.cas.dto.file.FileRequest;
import com.nishbs.cas.dto.file.FileResponse;
import com.nishbs.cas.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/file")
@AllArgsConstructor
public class FileController {

    private FileService fileService;

    @PostMapping
    public ResponseEntity<Void> createFile(@RequestBody FileRequest customerRequest) {
        fileService.save(customerRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("all")
    public List<FileResponse> inquireAllFiles() {
        return fileService.inquireAllFiles();
    }

    @DeleteMapping(value = "deleteById/{id}")
    public ResponseEntity<Boolean> deleteCustomerById(@PathVariable Long id) {
        Boolean response = fileService.deleteFile(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "deleteByName/{name}")
    public ResponseEntity<Boolean> deleteCustomerByName(@PathVariable String name) {
        Boolean response = fileService.deleteFile(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<FileResponse> deleteCustomerByName(@RequestBody FileRequest request) {
        FileResponse response = fileService.updateFile(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
