package acad.reddragon.api.treino;

import acad.reddragon.api.detalhe_treino.DetalheTreino;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "treinos")
public class Treino {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    @Column(name = "tipo_treino")
    private String tipoTreino;
    @Column(name = "aluno_id")
    private BigInteger alunoId;

    @Getter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "treino")
    private List<DetalheTreino> detalhesTreino;

    @JsonCreator
    public Treino(@JsonProperty("tipoTreino") String tipoTreino,
                  @JsonProperty("alunoId") BigInteger alunoId,
                  @JsonProperty("detalhesTreino") List<DetalheTreino> detalhesTreino) {
        this.tipoTreino = tipoTreino;
        this.alunoId = alunoId;
        this.detalhesTreino = new ArrayList<>();

        for (DetalheTreino detalhe : detalhesTreino) {
            detalhe.setTreino(this);
            this.detalhesTreino.add(detalhe);
            new DetalheTreino(
                    this,
                    detalhe.getExercicioId(),
                    detalhe.getSeries(),
                    detalhe.getRepeticoes(),
                    detalhe.getTecnica(),
                    detalhe.getExercicioAdicionalId());
            System.out.println(detalhe);
            System.out.println("ExercicioId: " + detalhe.getExercicioId());
            System.out.println("Series: " + detalhe.getSeries());
            System.out.println("Repeticoes: " + detalhe.getRepeticoes());
            System.out.println("Tecnica: " + detalhe.getTecnica());
            System.out.println("ExercicioAdicionalId: " + detalhe.getExercicioAdicionalId());
            System.out.println("--------------");
        }
    }
}
