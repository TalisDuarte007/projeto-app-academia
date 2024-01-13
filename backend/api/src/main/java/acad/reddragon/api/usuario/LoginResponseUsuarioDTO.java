package acad.reddragon.api.usuario;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class LoginResponseUsuarioDTO {
    private Long id;
    private String nome;
    private String role;
    private String email;
}
