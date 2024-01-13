//package acad.reddragon.api.controller;
//
//import acad.reddragon.api.aluno.Aluno;
//import acad.reddragon.api.aluno.AlunoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("alunos")
//public class AlunoController {
//    @Autowired
//    private AlunoRepository alunoRepository;
////    @PostMapping
////    public void cadastrar(@RequestBody @Valid DadosCadastroAluno dados) {
////        alunoRepository.save(new Aluno(dados));
////    }
//    @GetMapping
//    public List<Aluno> lista() {
//        return alunoRepository.findAll();
//    }
//    @GetMapping("/{id}")
//    public DadosListagemAlunos obterAluno(@PathVariable Long id) {
//        Aluno aluno = alunoRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
//        return new DadosListagemAlunos(aluno);
//    }
//}


