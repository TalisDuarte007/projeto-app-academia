package acad.reddragon.api.usuario;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UsuarioDTO {
    private Long id;
    private String nome;
    private  Long idProfessor;
}
