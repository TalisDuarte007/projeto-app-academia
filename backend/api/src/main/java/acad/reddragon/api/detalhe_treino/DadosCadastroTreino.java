package acad.reddragon.api.detalhe_treino;
import java.math.BigInteger;
public record DadosCadastroTreino(
        BigInteger exercicioId,
        int series,
        int repeticoes,
        String tecnica,
        BigInteger exercicioAdicionalId
) {
}
