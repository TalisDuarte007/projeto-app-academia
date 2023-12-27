package acad.reddragon.api.controller;

import acad.reddragon.api.exercicio.*;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/exercicios")
public class ExercicioController {

    @Autowired
    private ExercicioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroExercicio dados){
        repository.save(new Exercicio(dados));
    }

    @GetMapping
    public List<DadosListagemExercicio> lista(@RequestParam(value = "categoria", required = false) Categoria categoria) {
        List<DadosListagemExercicio> listaCompleta = repository.findAll().stream()
                .filter(exercicio -> categoria == null || exercicio.getCategoria() == categoria)
                .map(DadosListagemExercicio::new)
                .collect(Collectors.toList());

        return listaCompleta;
    }

}