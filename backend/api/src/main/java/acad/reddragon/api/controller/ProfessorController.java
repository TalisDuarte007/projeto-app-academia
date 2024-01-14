package acad.reddragon.api.controller;

import acad.reddragon.api.aluno.Aluno;
import acad.reddragon.api.aluno.AlunoDTO;
import acad.reddragon.api.aluno.AlunoRepository;
import acad.reddragon.api.professor.Professor;
import acad.reddragon.api.professor.ProfessorDTO;
import acad.reddragon.api.professor.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("professor")
public class ProfessorController {
    @Autowired
    private ProfessorRepository repository;

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDTO> getProfessorDetails(@PathVariable Long id) {
        Professor professor = repository.findById(id)
                .orElse(null);

        if (professor != null){
            ProfessorDTO professorDTO = new ProfessorDTO();
            professorDTO.setId(professor.getId());
            professorDTO.setNome(professorDTO.getNome());

            return ResponseEntity.ok(professorDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/alunos")
    public ResponseEntity<List<AlunoDTO>> getAlunosDoProfessor(@PathVariable Long id) {
        Optional<Professor> professorOptional = repository.findById(id);

        if (professorOptional.isPresent()) {
            Professor professor = professorOptional.get();

            List<Aluno> alunosDoProfessor = alunoRepository.findByProfessor(professor);

            List<AlunoDTO> alunosDTO = alunosDoProfessor.stream()
                    .map(aluno -> {
                        AlunoDTO alunoDTO = new AlunoDTO();
                        alunoDTO.setId(aluno.getId());

                        // Verifica se o Usuario é nulo antes de acessar suas propriedades
                        if (aluno.getUsuario() != null) {
                            alunoDTO.setNome(aluno.getUsuario().getNome());
                            // Adicione outras propriedades do Usuario conforme necessário
                        }

                        return alunoDTO;
                    })
                    .collect(Collectors.toList());

            return ResponseEntity.ok(alunosDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
