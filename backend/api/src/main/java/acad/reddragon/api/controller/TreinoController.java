package acad.reddragon.api.controller;

import acad.reddragon.api.detalhe_treino.DetalheTreino;
import acad.reddragon.api.treino.Treino;
import acad.reddragon.api.treino.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("treinos")
public class TreinoController {
    @Autowired
    private TreinoRepository repository;
    @PostMapping
    public ResponseEntity<Treino> criarTreino(@RequestBody Treino treino) {
        // Lógica para criar um novo treino
        List<DetalheTreino> detalhesTreino = treino.getDetalhesTreino();

        // Iterar sobre os detalhes do treino e salvar individualmente
        for (DetalheTreino detalhe : detalhesTreino) {
            // Lógica para salvar detalhe no banco de dados
            // repository.save(detalhe);
        }

        Treino novoTreino = repository.save(treino);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTreino);
    }

}
