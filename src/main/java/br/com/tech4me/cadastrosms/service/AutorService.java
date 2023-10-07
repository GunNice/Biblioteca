package br.com.tech4me.cadastrosms.service;
import java.util.List;
import java.util.Optional;

import br.com.tech4me.cadastrosms.shared.AutorCompletoDto;
import br.com.tech4me.cadastrosms.shared.AutorDto;

public interface AutorService {
    List<AutorDto> obterAutores();
    Optional<AutorCompletoDto> obterPorId(String id);
    AutorCompletoDto cadastrarAutores(AutorCompletoDto dto);
    AutorCompletoDto atualizarPorId(String id, AutorCompletoDto dto);
    void excluirPorId(String id);
}

