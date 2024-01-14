package acad.reddragon.api.aluno;

import acad.reddragon.api.professor.Professor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AlunoDTO {
    private Long id;
    private String nome;
}