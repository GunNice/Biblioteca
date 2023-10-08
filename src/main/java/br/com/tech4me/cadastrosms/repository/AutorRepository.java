package br.com.tech4me.cadastrosms.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.cadastrosms.model.Autor;


public interface AutorRepository extends MongoRepository<Autor, String>{
    
}
