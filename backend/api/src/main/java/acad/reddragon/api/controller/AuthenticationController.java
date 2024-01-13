package acad.reddragon.api.controller;

import acad.reddragon.api.aluno.Aluno;
import acad.reddragon.api.aluno.AlunoRepository;
import acad.reddragon.api.infra.security.TokenService;
import acad.reddragon.api.professor.Professor;
import acad.reddragon.api.usuario.*;
import acad.reddragon.api.professor.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO data) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            // Obtenha o usuário autenticado
            Usuario authenticatedUser = (Usuario) auth.getPrincipal();

            // Crie o DTO com as informações desejadas
            LoginResponseUsuarioDTO UsuarioDTO = new LoginResponseUsuarioDTO();
            UsuarioDTO.setId(authenticatedUser.getId());
            UsuarioDTO.setNome(authenticatedUser.getNome());
            UsuarioDTO.setRole(String.valueOf(authenticatedUser.getRole()));
            UsuarioDTO.setEmail(authenticatedUser.getEmail());

            // Gere o token
            var token = tokenService.generateToken(authenticatedUser);

            // Construa o objeto de resposta
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("user", UsuarioDTO);

            return ResponseEntity.ok(response);
        } catch (org.springframework.security.core.AuthenticationException e) {
            // Adicione logs para depuração
            log.error("Authentication failed: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }



    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (this.repository.findByEmail(data.email()) != null) {
            return ResponseEntity.badRequest().build();
        }

        UsuarioRole role = data.role();
        if (role == null || (role != UsuarioRole.ALUNO && role != UsuarioRole.PROFESSOR)) {
            return ResponseEntity.badRequest().body("A role do usuário é inválida.");
        }
        System.out.println(data);

        // Verifique se o papel é um aluno antes de salvar o usuário
        if (role == UsuarioRole.ALUNO) {
            Long idProfessor = data.idProfessor();
            System.out.println(idProfessor);
            if (idProfessor == null) {
                return ResponseEntity.badRequest().body("O ID do professor é obrigatório para criar um aluno.");
            }

            Professor professor = professorRepository.findById(idProfessor)
                    .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado com o ID fornecido"));

            String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
            Usuario novoUsuario = new Usuario(data.nome(), data.email(), encryptedPassword, role);

            // Salve o usuário antes de associá-lo a um professor ou aluno
            Usuario savedUser = repository.save(novoUsuario);

            // Crie e salve o aluno com o usuário salvo
            Aluno aluno = new Aluno(professor, savedUser);
            alunoRepository.save(aluno);
        } else if (role == UsuarioRole.PROFESSOR) {
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
            Usuario novoUsuario = new Usuario(data.nome(), data.email(), encryptedPassword, role);

            // Salve o usuário antes de associá-lo a um professor
            Usuario savedUser = repository.save(novoUsuario);

            // Crie e salve o professor com o usuário salvo
            Professor professor = new Professor(savedUser);
            professorRepository.save(professor);
        }

        return ResponseEntity.ok().build();
    }


}
