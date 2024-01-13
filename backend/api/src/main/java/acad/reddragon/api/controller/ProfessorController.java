package acad.reddragon.api.controller;

import acad.reddragon.api.professor.Professor;
import acad.reddragon.api.professor.ProfessorDTO;
import acad.reddragon.api.professor.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("professor")
public class ProfessorController {
    @Autowired
    private ProfessorRepository repository;

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
}
