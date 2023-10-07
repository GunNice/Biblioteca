package br.com.tech4me.cadastrosms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.cadastrosms.model.Livro;
import br.com.tech4me.cadastrosms.repository.LivroRepository;
import br.com.tech4me.cadastrosms.shared.LivroCompletoDto;
import br.com.tech4me.cadastrosms.shared.LivroDto;


@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository repositorio;

    @Override
    public List<LivroDto> obterLivros() {
        return repositorio.findAll()
            .stream()
            .map(p -> new LivroDto(p.getTitulo(), p.getEditora(), p.getAutor()))
            .toList();
    }

    @Override
    public Optional<LivroCompletoDto> obterPorId(String id) {
        Optional<Livro> livro = repositorio.findById(id);

        if (livro.isPresent()) {
            return Optional.of(new LivroCompletoDto(livro.get().getId(),
                livro.get().getTitulo(),
                livro.get().getEditora()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public LivroCompletoDto cadastrar(LivroCompletoDto dto) {
        Livro livro = new Livro(dto);
        repositorio.save(livro);

        return new LivroCompletoDto(livro.getId(),
            livro.getTitulo(),
            livro.getEditora());
    }

    @Override
    public LivroCompletoDto atualizarPorId(String id, LivroCompletoDto dto) {
        Livro livro = repositorio.findById(id).orElse(null);

        if (livro != null) {
            Livro livroAtualizar = new Livro(dto);
            livroAtualizar.setId(id);
            repositorio.save(livroAtualizar);
            return new LivroCompletoDto(livroAtualizar.getId(),
                livroAtualizar.getTitulo(),
                livroAtualizar.getEditora());
        } else {
            return null;
        }
    }

    @Override
    public void excluirPorId(String id) {
        repositorio.deleteById(id);
    }
    
}
