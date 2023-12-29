package acad.reddragon.api.controller;

import acad.reddragon.api.exercicio.*;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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

    @GetMapping("/categorias")
    public List<String> listarCategorias() {
        return Arrays.stream(Categoria.values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<Exercicio> listaTodos() {
        return repository.findAll();
    }


    @GetMapping("/{idExercicio}")
    public ResponseEntity<DadosListagemExercicio> buscaPorId(@PathVariable Long idExercicio) {
        Exercicio exercicio = repository.findById(idExercicio).orElse(null);
        if (exercicio == null) {
            return ResponseEntity.notFound().build();
        }
        DadosListagemExercicio dadosExercicio = new DadosListagemExercicio(exercicio);
        return ResponseEntity.ok(dadosExercicio);
    }


}
