package br.com.tech4me.cadastrosms.shared;


import br.com.tech4me.cadastrosms.model.Editora;

public record LivroDto (String id, String titulo, String autorId, Editora editora){
    
}
