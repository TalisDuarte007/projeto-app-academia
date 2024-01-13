package acad.reddragon.api.professor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query("SELECT p.id FROM Professor p WHERE p.usuario.id = :usuarioId")
    Long findIdByUsuarioId(@Param("usuarioId") Long usuarioId);
}
