package acad.reddragon.api.controller;

import acad.reddragon.api.detalhe_treino.DetalheTreino;
import acad.reddragon.api.treino.Treino;
import acad.reddragon.api.treino.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping("/alunos/{id}/treinos/{treinoId}")
    public ResponseEntity<Optional<Treino>> buscarTreinoDoAlunoById(@PathVariable Long id, @PathVariable Long treinoId) {
        Optional<Treino> treinoDoAluno = repository.findById(BigInteger.valueOf(treinoId));
        return ResponseEntity.ok(treinoDoAluno);
    }

    @GetMapping("/alunos/{id}/treinos/{treinoId}/exercicios/{exercicioId}")
    public ResponseEntity<Optional<DetalheTreino>> buscarExercicioDoTreinoById(
            @PathVariable Long id,
            @PathVariable Long treinoId,
            @PathVariable Long exercicioId) {

        Optional<Treino> treinoDoAluno = repository.findById(BigInteger.valueOf(treinoId));

        if (treinoDoAluno.isPresent()) {
            List<DetalheTreino> detalhesTreino = treinoDoAluno.get().getDetalhesTreino();

            Optional<DetalheTreino> exercicio = detalhesTreino.stream()
                    .filter(det -> det.getId().equals(BigInteger.valueOf(exercicioId)))
                    .findFirst();

            return ResponseEntity.of(Optional.of(exercicio));
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

    @PutMapping("/alunos/{id}/treinos/{treinoId}/exercicio/{exercicioId}")
    public ResponseEntity<DetalheTreino> atualizarExercicioDoTreino(
            @PathVariable Long id,
            @PathVariable Long treinoId,
            @PathVariable Long exercicioId,
            @RequestBody DetalheTreino novoExercicio) {

        Optional<Treino> treinoDoAluno = repository.findById(BigInteger.valueOf(treinoId));

        if (treinoDoAluno.isPresent()) {
            List<DetalheTreino> detalhesTreino = treinoDoAluno.get().getDetalhesTreino();

            for (DetalheTreino exercicio : detalhesTreino) {
                if (exercicio.getId().equals(BigInteger.valueOf(exercicioId))) {
                    // Atualiza os dados do exercício com os novos dados fornecidos
                    exercicio.setCarga(novoExercicio.getCarga());
                    // Adicione aqui os outros campos que deseja atualizar

                    // Salva as alterações no treino
                    repository.save(treinoDoAluno.get());

                    return ResponseEntity.ok(exercicio);
                }
            }

            // Se o exercício não for encontrado, retorne um status 404 (Not Found)
            return ResponseEntity.notFound().build();
        } else {
            // Se o treino não for encontrado, retorne um status 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }

}


