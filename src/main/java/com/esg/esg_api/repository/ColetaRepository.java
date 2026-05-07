package com.esg.esg_api.repository;

import com.esg.esg_api.model.ColetaModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ColetaRepository extends MongoRepository<ColetaModel, String> {
}