package acad.reddragon.api.detalhe_treino;

import acad.reddragon.api.treino.Treino;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalhes_treino")
public class DetalheTreino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private BigInteger id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "treino_id")
    private Treino treino;

    @Getter
    @Column(name = "exercicio_id")
    private BigInteger exercicioId;

    @Getter
    @Column(name = "series")
    private int series;

    @Getter
    @Column(name = "repeticoes")
    private int repeticoes;

    @Getter
    @Column(name = "tecnica")
    private String tecnica;

    @Getter
    @Column(name = "exercicio_adicional_id")
    private BigInteger exercicioAdicionalId;

    public DetalheTreino(Treino treino, BigInteger exercicioId, int series, int repeticoes, String tecnica, BigInteger exercicioAdicionalId) {
        this.treino = treino;
        this.exercicioId = exercicioId;
        this.series = series;
        this.repeticoes = repeticoes;
        this.tecnica = tecnica;
        this.exercicioAdicionalId = exercicioAdicionalId;
    }

    @Override
    public String toString() {
        return "DetalheTreino{" +
                "id=" + id +
                ", treino=" + treino.getId() + // Use o getId() ou outra representação adequada
                ", exercicioId=" + exercicioId +
                ", series=" + series +
                ", repeticoes=" + repeticoes +
                ", tecnica='" + tecnica + '\'' +
                ", exercicioAdicionalId=" + exercicioAdicionalId +
                '}';
    }
}

