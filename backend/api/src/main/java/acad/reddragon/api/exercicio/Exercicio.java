package acad.reddragon.api.exercicio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "exercicios")
@Entity(name = "Exercicio")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Exercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String musculo_trabalhado;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    public Exercicio (DadosCadastroExercicio dados){
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.musculo_trabalhado = dados.musculo_trabalhado();
        this.categoria = dados.categoria();
    }

    public Exercicio (Exercicio exercicio){
        this.nome = exercicio.getNome();
        this.descricao = exercicio.getDescricao();
        this.musculo_trabalhado = exercicio.getMusculoTrabalhado();
        this.categoria = exercicio.getCategoria();
    }

    private String getMusculoTrabalhado() {
        return musculo_trabalhado;
    }
}
