package acad.reddragon.api.treino;

import acad.reddragon.api.detalhe_treino.DetalheTreino;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Setter
    @Getter
    @Column(name = "tipo_treino")
    private String tipoTreino;
    @Column(name = "aluno_id")
    private BigInteger alunoId;

    @Getter
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "treino")
    private List<DetalheTreino> detalhesTreino;

    public Treino() {
        // Construtor padrão sem argumentos
    }

    @JsonCreator
    public Treino(@JsonProperty("tipoTreino") String tipoTreino,
                  @JsonProperty("alunoId") BigInteger alunoId,
                  @JsonProperty("treinoId") BigInteger id,
                  @JsonProperty("detalhesTreino") List<DetalheTreino> detalhesTreino) {
        this.tipoTreino = tipoTreino;
        this.alunoId = alunoId;
        this.id = id;
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
                    detalhe.getDescanso(),
                    detalhe.getCarga());
        }
    }
}
