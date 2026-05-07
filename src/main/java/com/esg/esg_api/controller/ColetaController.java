package com.esg.esg_api.controller;

import com.esg.esg_api.model.ColetaModel;
import com.esg.esg_api.repository.ColetaRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coletas")
public class ColetaController {

    private final ColetaRepository repository;

    public ColetaController(ColetaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ColetaModel> listar() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ColetaModel criar(@RequestBody ColetaModel coleta) {
        return repository.save(coleta);
    }

    @GetMapping("/teste")
    public ColetaModel criar() {
        ColetaModel c = new ColetaModel();
        c.setBairro("TESTE");
        c.setStatus("OK");
        return repository.save(c);
    }
}