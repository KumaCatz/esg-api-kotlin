package com.esg.esg_api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Data
@Document(collection = "coleta_lixo")
public class ColetaModel {

    @Id
    private String id;

    @NotBlank(message = "Bairro obrigatório")
    private String bairro;

    @NotBlank(message = "Status obrigatório")
    @Pattern(
        regexp = "pendente|realizada",
        message = "Status inválido"
    )
    private String status;
}