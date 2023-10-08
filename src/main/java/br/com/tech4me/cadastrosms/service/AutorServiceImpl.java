package br.com.tech4me.cadastrosms.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.cadastrosms.model.Autor;
import br.com.tech4me.cadastrosms.repository.AutorRepository;
import br.com.tech4me.cadastrosms.shared.AutorCompletoDto;
import br.com.tech4me.cadastrosms.shared.AutorDto;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository repositorio;

    @Override
    public List<AutorDto> obterAutores() {
        return repositorio.findAll()
            .stream()
            .map(p -> new AutorDto(p.getNome(), p.getNascimento()))
            .toList();
    }
 

    @Override
    public Optional<AutorCompletoDto> obterPorId(String id) {
        Optional<Autor> autor = repositorio.findById(id);

        if (autor.isPresent()) {
            return Optional.of(new AutorCompletoDto(autor.get().getId(),
                autor.get().getNome(),
                autor.get().getNascimento()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public AutorCompletoDto cadastrarAutores(AutorCompletoDto dto) {
        Autor autor = new Autor(dto);
        repositorio.save(autor);

        return new AutorCompletoDto(autor.getId(),
            autor.getNome(),
            autor.getNascimento());
    }

    @Override
    public AutorCompletoDto atualizarPorId(String id, AutorCompletoDto dto) {
        Autor autor = repositorio.findById(id).orElse(null);

        if (autor != null) {
            Autor autorAtualizar = new Autor(dto);
            autorAtualizar.setId(id);
            repositorio.save(autorAtualizar);
            return new AutorCompletoDto(autorAtualizar.getId(),
                autorAtualizar.getNome(),
                autorAtualizar.getNascimento());
        } else {
            return null;
        }
    }

    @Override
    public void excluirPorId(String id) {
        repositorio.deleteById(id);
    }
    
    
}
