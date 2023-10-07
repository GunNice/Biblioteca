package br.com.tech4me.cadastrosms.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import br.com.tech4me.cadastrosms.shared.AutorCompletoDto;
@Document("autor")
public class Autor {
    @Id
    private String id;
    private String nome;
    private LocalDate nascimento;

    public Autor() {}

    public Autor(AutorCompletoDto dto) {
        this.id = dto.id();
        this.nome = dto.nome();
       
      
    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public LocalDate getNascimento() {
        return nascimento;
    }
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    
}
