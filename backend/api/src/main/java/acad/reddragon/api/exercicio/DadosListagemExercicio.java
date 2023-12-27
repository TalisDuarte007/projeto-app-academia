package acad.reddragon.api.exercicio;

public record DadosListagemExercicio(
        String nome,
        String descricao,
        String musculo_trabalhado
) {
    public DadosListagemExercicio(Exercicio exercicio){
        this(exercicio.getNome(), exercicio.getDescricao(), exercicio.getMusculo_trabalhado());
    }
}
