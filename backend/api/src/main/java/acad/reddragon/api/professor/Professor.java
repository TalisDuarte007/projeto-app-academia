package acad.reddragon.api.professor;

import acad.reddragon.api.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL) // Adicione a anotação cascade aqui
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Professor(Usuario usuario) {
        this.usuario = usuario;
    }
}
