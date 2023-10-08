package br.com.tech4me.cadastrosms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.cadastrosms.service.LivroService;
import br.com.tech4me.cadastrosms.shared.LivroCompletoDto;
import br.com.tech4me.cadastrosms.shared.LivroDto;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/livros")
public class LivroController {
    
    
    @Autowired
    private LivroService servico;

     @GetMapping("/porta")
    private String obterPorta(@Value("${local.server.port}") String porta) {
        return "A instância que respondeu a requisição está rodando na porta " + porta;
    }
    
    @GetMapping
    private ResponseEntity<List<LivroDto>> obterLivros() {
        return new ResponseEntity<>(servico.obterLivros(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<LivroCompletoDto> obterLivrosPorId(@PathVariable String id) {
        Optional<LivroCompletoDto> livro = servico.obterPorId(id);

        if (livro.isPresent()) {
            return new ResponseEntity<>(livro.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    private ResponseEntity<LivroCompletoDto> cadastrarLivro(@RequestBody @Valid LivroCompletoDto livro) {
        return new ResponseEntity<>(servico.cadastrar(livro), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> excluirLivroPorId(@PathVariable String id) {
        servico.excluirPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    private ResponseEntity<LivroCompletoDto> atualizarAutor(@PathVariable String id, @RequestBody @Valid LivroCompletoDto livro) {
        LivroCompletoDto livroAtualizado = servico.atualizarPorId(id, livro);

        if (livroAtualizado != null) {
            return new ResponseEntity<>(livroAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
 

