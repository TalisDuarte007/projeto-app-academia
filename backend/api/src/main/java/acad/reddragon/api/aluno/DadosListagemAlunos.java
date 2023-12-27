package acad.reddragon.api.aluno;

public record DadosListagemAlunos (
        String nome) {
    public DadosListagemAlunos(Aluno aluno){
        this(aluno.getNome());
    }

}
