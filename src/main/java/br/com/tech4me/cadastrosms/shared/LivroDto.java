package br.com.tech4me.cadastrosms.shared;

import br.com.tech4me.cadastrosms.model.Autor;
import br.com.tech4me.cadastrosms.model.Editora;

public record LivroDto (String nome, Editora editora, Autor autor){
    
}
