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
    private String musculo_trabalhado;
    private String link_gif;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    public Exercicio (DadosCadastroExercicio dados){
        this.nome = dados.nome();
        this.musculo_trabalhado = dados.musculo_trabalhado();
        this.categoria = dados.categoria();
        this.link_gif = dados.link_gif();
    }

    public Exercicio (Exercicio exercicio){
        this.nome = exercicio.getNome();
        this.musculo_trabalhado = exercicio.getMusculoTrabalhado();
        this.categoria = exercicio.getCategoria();
        this.link_gif = exercicio.getLink_gif();
    }

    private String getMusculoTrabalhado() {
        return musculo_trabalhado;
    }
}
