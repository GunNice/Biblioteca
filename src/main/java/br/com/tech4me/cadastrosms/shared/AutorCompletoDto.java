package br.com.tech4me.cadastrosms.shared;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public record AutorCompletoDto (String id,
    @NotEmpty(message = "Campo nome deve ser informado!")
    @NotBlank(message = "Tá com caracteres em branco mas sem o nome.")
    String nome,
     @NotNull(message = "Informe a data de nascimento ")
     LocalDate nascimento)
   {
    
}
