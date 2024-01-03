package acad.reddragon.api.detalhe_treino;

import acad.reddragon.api.treino.Treino;

import java.math.BigInteger;

public record DadosCadastroDetalheTreino(
        Treino treino,
        BigInteger exercicioId,
        int series,
        int repeticoes,
        String tecnica,
        int descanso,
        float carga,
        BigInteger exercicioAdicionalId
) {
}
