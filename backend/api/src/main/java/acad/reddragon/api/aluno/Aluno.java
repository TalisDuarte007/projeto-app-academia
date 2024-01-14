package acad.reddragon.api.aluno;

import acad.reddragon.api.professor.Professor;
import acad.reddragon.api.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;  // Alterado para Professor

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    // Construtor com parâmetros
    public Aluno(Professor professor, Usuario usuario) {  // Alterado para Professor
        this.professor = professor;
        this.usuario = usuario;
    }
}

