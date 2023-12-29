package acad.reddragon.api.controller;

import acad.reddragon.api.aluno.Aluno;
import acad.reddragon.api.aluno.AlunoRepository;
import acad.reddragon.api.aluno.DadosCadastroAluno;
import acad.reddragon.api.aluno.DadosListagemAlunos;
import acad.reddragon.api.exercicio.DadosListagemExercicio;
import acad.reddragon.api.treino.Treino;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("alunos")
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepository;
    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroAluno dados) {
        alunoRepository.save(new Aluno(dados));
    }
    @GetMapping
    public List<Aluno> lista() {
        return alunoRepository.findAll();
    }
    @GetMapping("/{id}")
    public DadosListagemAlunos obterAluno(@PathVariable Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
        return new DadosListagemAlunos(aluno);
    }
}


