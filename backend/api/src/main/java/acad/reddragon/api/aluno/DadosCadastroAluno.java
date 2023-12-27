package acad.reddragon.api.aluno;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAluno(
        @NotBlank
        String nome){
}
