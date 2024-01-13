package acad.reddragon.api.aluno;

import lombok.Data;

@Data
public class AlunoDTO {
    private Long id;
    private String nome;

    public AlunoDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}