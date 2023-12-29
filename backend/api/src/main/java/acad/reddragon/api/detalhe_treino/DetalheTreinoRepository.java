package acad.reddragon.api.detalhe_treino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface DetalheTreinoRepository  extends JpaRepository<DetalheTreino, BigInteger> {
}
