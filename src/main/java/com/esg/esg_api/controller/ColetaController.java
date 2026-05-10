package com.esg.esg_api.controller;

import com.esg.esg_api.model.ColetaModel;
import com.esg.esg_api.repository.ColetaRepository;

import jakarta.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/{id}")
    public ColetaModel buscarPorId(@PathVariable String id) {
        
        return repository.findById(id)
                .orElseThrow(() ->
                    new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Coleta não encontrada"
                    )
                );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ColetaModel criar(@Valid @RequestBody ColetaModel coleta) {
        return repository.save(coleta);
    }

    @PutMapping("/{id}")
    public ColetaModel atualizar(@PathVariable String id, @RequestBody ColetaModel coletaAtualizada) {
        if (!ObjectId.isValid(id)) {
            throw new IllegalArgumentException("ID inválido");
        }

        ColetaModel coleta = repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Coleta não encontrada")
                );

        coleta.setBairro(coletaAtualizada.getBairro());
        coleta.setStatus(coletaAtualizada.getStatus());

        return repository.save(coleta);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable String id) {

        if (!ObjectId.isValid(id)) {
            throw new IllegalArgumentException("ID inválido");
        }

        ColetaModel coleta = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coleta não encontrada"));

        repository.delete(coleta);
    }
}