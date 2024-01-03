package acad.reddragon.api.exercicio;

public record DadosListagemExercicio(
        String nome,
        String musculo_trabalhado,
        String link_gif
) {
    public DadosListagemExercicio(Exercicio exercicio){
        this(exercicio.getNome(), exercicio.getMusculo_trabalhado(), exercicio.getLink_gif());
    }
}
