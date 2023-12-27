package acad.reddragon.api.controller;

import acad.reddragon.api.aluno.Aluno;
import acad.reddragon.api.aluno.AlunoRepository;
import acad.reddragon.api.aluno.DadosCadastroAluno;
import acad.reddragon.api.aluno.DadosListagemAlunos;
import acad.reddragon.api.exercicio.DadosListagemExercicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("alunos")
public class AlunoController {
    @Autowired
    private AlunoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroAluno dados){
        repository.save(new Aluno(dados));
    }

    @GetMapping
    public Page<DadosListagemAlunos> lista(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemAlunos::new);
    }

}

