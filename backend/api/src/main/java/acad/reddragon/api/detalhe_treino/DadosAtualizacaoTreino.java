package acad.reddragon.api.detalhe_treino;

import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record DadosAtualizacaoTreino (
        @NotNull
        BigInteger id,
        Float carga) {
}
