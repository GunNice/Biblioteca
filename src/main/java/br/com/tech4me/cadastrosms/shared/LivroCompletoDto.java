package br.com.tech4me.cadastrosms.shared;

import br.com.tech4me.cadastrosms.model.Editora;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public record LivroCompletoDto (String id,
    @NotEmpty(message = "Campo nome deve ser informado!")
    @NotBlank(message = "Tá com caracteres em branco mas sem o nome.")
    String titulo,
    @NotNull(message = "Valores válidos:  ALEPH, SUMA, ROCCO, GLOBO, SARAIVA, GENTE ")
    Editora editora){
    
}