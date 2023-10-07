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

import br.com.tech4me.cadastrosms.service.AutorService;
import br.com.tech4me.cadastrosms.shared.AutorCompletoDto;
import br.com.tech4me.cadastrosms.shared.AutorDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService servico;

     @GetMapping("/porta")
    private String obterPorta(@Value("${local.server.port}") String porta) {
        return "A instância que respondeu a requisição está rodando na porta " + porta;
    }
    
    @GetMapping
    private ResponseEntity<List<AutorDto>> obterAutores() {
        return new ResponseEntity<>(servico.obterAutores(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<AutorCompletoDto> obterAutorPorId(@PathVariable String id) {
        Optional<AutorCompletoDto> autor = servico.obterPorId(id);

        if (autor.isPresent()) {
            return new ResponseEntity<>(autor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    private ResponseEntity<AutorCompletoDto> cadastrarAutores(@RequestBody @Valid AutorCompletoDto autor) {
        return new ResponseEntity<>(servico.cadastrarAutores(autor), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> excluirAutorPorId(@PathVariable String id) {
        servico.excluirPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    private ResponseEntity<AutorCompletoDto> atualizarAutor(@PathVariable String id, @RequestBody @Valid AutorCompletoDto autor) {
        AutorCompletoDto autorAtualizado = servico.atualizarPorId(id, autor);

        if (autorAtualizado != null) {
            return new ResponseEntity<>(autorAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
