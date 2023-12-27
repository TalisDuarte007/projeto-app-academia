package acad.reddragon.api.treino;

import acad.reddragon.api.detalhe_treino.DetalheTreino;

import java.math.BigInteger;
import java.util.List;

public record DadosCadastroTreino(
        BigInteger id,
        String tipoTreino,
        BigInteger alunoId,
        List<DetalheTreino> detalhesTreino
) {
}

