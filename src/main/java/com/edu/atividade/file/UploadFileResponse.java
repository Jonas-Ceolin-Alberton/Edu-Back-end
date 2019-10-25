package com.edu.atividade.file;

public class UploadFileResponse {

    private String id;

    private String fileName;

    public UploadFileResponse(String id, String name) {
        this.id = id;
        this.fileName = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}