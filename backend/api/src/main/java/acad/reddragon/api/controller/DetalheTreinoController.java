package acad.reddragon.api.controller;

import acad.reddragon.api.detalhe_treino.DetalheTreino;
import acad.reddragon.api.detalhe_treino.DetalheTreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("detalhes-treino")
public class DetalheTreinoController {

    @Autowired
    private DetalheTreinoRepository repository;

    @PostMapping
    public ResponseEntity<DetalheTreino> cadastrar(@RequestBody DetalheTreino dados) {
        DetalheTreino novoDetalheTreino = repository.save(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoDetalheTreino);
    }

}

