package acad.reddragon.api.aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
