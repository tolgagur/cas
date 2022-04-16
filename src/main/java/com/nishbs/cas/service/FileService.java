package com.nishbs.cas.service;

import com.nishbs.cas.dto.file.FileRequest;
import com.nishbs.cas.dto.file.FileResponse;
import com.nishbs.cas.model.Mapper;
import com.nishbs.cas.model.file.File;
import com.nishbs.cas.repository.file.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class FileService {

    private FileRepository fileRepository;

    public void save(FileRequest fileRequest) {
        File file = new File();
        file.setFileName(fileRequest.getFileName());
        file.setCreatedDate(Instant.now());
        file.setCustomerId(fileRequest.getCustomerId());
        fileRepository.save(file);
    }

    public List<FileResponse> inquireAllFiles() {
        List<FileResponse> response = new ArrayList<>();
        for (File f : fileRepository.findAll()){
            response.add(Mapper.mapper.map(f, FileResponse.class));
        }
        return response;
    }

    public boolean deleteFile(Long id) {
        Optional<File> file = fileRepository.findById(id);
        if (!file.isPresent())
            return false;

        fileRepository.deleteById(id);
        return true;
    }

    public boolean deleteFile(String name) {
        List<File> files = fileRepository.findByFileName(name);
        if (files.isEmpty())
            return false;

        fileRepository.deleteCustomersByFileName(name);
        return true;
    }

    public FileResponse updateFile(FileRequest request) {
        Optional<File> fileOpt = fileRepository.findById(request.getId());
        if (fileOpt.isPresent()) {
            File file = fileOpt.get();
            file.setFileName(request.getFileName());
            file.setCustomerId(request.getCustomerId());
            file = fileRepository.save(file);
            return Mapper.mapper.map(file, FileResponse.class);
        }
        throw new IllegalStateException("Customer not found");
    }
}
