package br.com.tech4me.cadastrosms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tech4me.cadastrosms.shared.LivroCompletoDto;
@Document("livros")
public class Livro {
    @Id
    private String id;
    private String titulo;
    private Editora editora;
    private Autor autor;
    private boolean locado;

    public Livro() {}

    public Livro(LivroCompletoDto dto) {
        this.id = dto.id();
        this.titulo = dto.titulo();
        this.editora = dto.editora();
    }
      
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Editora getEditora() {
        return editora;
    }
    public void setEditora(Editora editora) {
        this.editora = editora;
    }
    public Autor getAutor() {
        return autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    public boolean isLocado() {
        return locado;
    }
    public void setLocado(boolean locado) {
        this.locado = locado;
    }
    



}
