package acad.reddragon.api.exercicio;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroExercicio(
        @NotBlank
        String nome,
        String descricao,
        @NotBlank
        String musculo_trabalhado,
        @NotNull
        Categoria categoria

) {
}
