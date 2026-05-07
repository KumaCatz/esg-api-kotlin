package com.esg.esg_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "coleta_lixo")
public class ColetaModel {

    @Id
    private String id;

    private String bairro;
    private String status;

    public String getId() {
    return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}