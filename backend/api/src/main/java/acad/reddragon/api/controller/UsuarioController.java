package acad.reddragon.api.controller;

import acad.reddragon.api.professor.ProfessorRepository;
import acad.reddragon.api.usuario.Usuario;
import acad.reddragon.api.usuario.UsuarioDTO;
import acad.reddragon.api.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioDetails(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = repository.findById(id);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();

            // Criar UsuarioDTO a partir do usuario
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(usuario.getId());
            usuarioDTO.setNome(usuario.getNome());

            Long idProfessor = professorRepository.findIdByUsuarioId(usuario.getId());
            System.out.println(idProfessor);

            usuarioDTO.setIdProfessor(idProfessor);


            return ResponseEntity.ok(usuarioDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
