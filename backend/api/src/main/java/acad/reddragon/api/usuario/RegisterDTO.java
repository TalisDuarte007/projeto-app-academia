package acad.reddragon.api.usuario;

import lombok.Getter;


public record RegisterDTO(
        String nome,
        String email,
        String senha,
        UsuarioRole role,
        Long idProfessor
) {
}
