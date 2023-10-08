package br.com.tech4me.cadastrosms.repository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;



import br.com.tech4me.cadastrosms.model.Livro;

public interface LivroRepository extends MongoRepository<Livro, String>{
    List<Livro> findByAutorId(String autorId);
}