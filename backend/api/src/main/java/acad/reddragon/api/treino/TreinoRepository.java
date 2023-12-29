package acad.reddragon.api.treino;

import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigInteger;
import java.util.List;

public interface TreinoRepository extends JpaRepository<Treino, BigInteger> {
    List<Treino> findByAlunoId(BigInteger alunoId);
}





