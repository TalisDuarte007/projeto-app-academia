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

//    @GetMapping
//    public List<DetalheTreino> listarDetalhesTreino() {
//        return repository.listarDetalhesTreino();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<DetalheTreino> obterDetalheTreino(@PathVariable Long id) {
//        DetalheTreino detalheTreino = repository.obterDetalheTreino(id);
//        return ResponseEntity.ok(detalheTreino);
//    }

    @PostMapping
    public ResponseEntity<DetalheTreino> cadastrar(@RequestBody DetalheTreino dados) {
        DetalheTreino novoDetalheTreino = repository.save(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoDetalheTreino);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<DetalheTreino> atualizarDetalheTreino(@PathVariable Long id, @RequestBody DetalheTreino detalheTreino) {
//        DetalheTreino detalheAtualizado = repository.atualizarDetalheTreino(id, detalheTreino);
//        return ResponseEntity.ok(detalheAtualizado);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> excluirDetalheTreino(@PathVariable Long id) {
//        detalheTreinoService.excluirDetalheTreino(id);
//        return ResponseEntity.noContent().build();
//    }
}

