package acad.reddragon.api.aluno;
import acad.reddragon.api.professor.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByProfessor(Professor professor);
}
