package com.edu.aula;

import org.apache.tomcat.jni.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    public Aula storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
//            if(fileName.contains("..")) {
//                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
//            }

            Aula dbFile = new Aula(fileName, file.getContentType(), file.getBytes());

            return aulaRepository.save(dbFile);
        } catch (IOException ex) {
            throw new RuntimeException("No negative number please!");
//            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Aula getFile(String fileId) {
        return aulaRepository.findById(fileId)
                .orElseThrow(() -> new RuntimeException("File not found with id " + fileId));
    }
}
