package acad.reddragon.api.usuario;

public enum UsuarioRole {
    PROFESSOR("professor"),
    ALUNO ("aluno");

    private String role;

    UsuarioRole(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
