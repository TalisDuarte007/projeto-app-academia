package acad.reddragon.api.usuario;

public record AuthenticationDTO(
        String email,
        String senha
) {
}
