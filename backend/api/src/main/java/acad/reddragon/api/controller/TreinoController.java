package acad.reddragon.api.controller;

import acad.reddragon.api.detalhe_treino.DetalheTreino;
import acad.reddragon.api.treino.Treino;
import acad.reddragon.api.treino.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("treinos")
public class TreinoController {
    @Autowired
    private TreinoRepository repository;

    @GetMapping("/alunos/{id}/treinos")
    public ResponseEntity<List<Treino>> buscarTreinosDoAluno(@PathVariable Long id) {
        List<Treino> treinosDoAluno = repository.findByAlunoId(BigInteger.valueOf(id));

        if (!treinosDoAluno.isEmpty()) {
            return ResponseEntity.ok(treinosDoAluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<List<Treino>> criarTreinos(@RequestBody List<Treino> treinos) {
        List<Treino> novosTreinos = new ArrayList<>();

        for (Treino treino : treinos) {
            // Lógica para criar um novo treino
            List<DetalheTreino> detalhesTreino = treino.getDetalhesTreino();

            // Iterar sobre os detalhes do treino e salvar individualmente
            for (DetalheTreino detalhe : detalhesTreino) {
                // Lógica para salvar detalhe no banco de dados
                // repository.save(detalhe);
            }

            // Salvar o treino no banco de dados e adicionar à lista de novos treinos
            Treino novoTreino = repository.save(treino);
            novosTreinos.add(novoTreino);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(novosTreinos);
    }

}


