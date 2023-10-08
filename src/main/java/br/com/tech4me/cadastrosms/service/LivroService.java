package br.com.tech4me.cadastrosms.service;
import java.util.List;
import java.util.Optional;


import br.com.tech4me.cadastrosms.model.Livro;
import br.com.tech4me.cadastrosms.shared.LivroCompletoDto;
import br.com.tech4me.cadastrosms.shared.LivroDto;

public interface LivroService {
    List<LivroDto> obterLivros();
    Optional<LivroCompletoDto> obterPorId(String id);
    LivroCompletoDto cadastrar(LivroCompletoDto dto);
    LivroCompletoDto atualizarPorId(String id, LivroCompletoDto dto);
    void excluirPorId(String id);
    List<Livro> getLivrosDoAutor(String autorId);
}
