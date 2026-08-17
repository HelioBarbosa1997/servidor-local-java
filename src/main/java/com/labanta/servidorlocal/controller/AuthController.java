package com.labanta.servidorlocal.controller;

import com.labanta.servidorlocal.dto.LoginRequestDTO;
import com.labanta.servidorlocal.dto.RegistoRequestDTO;
import com.labanta.servidorlocal.exception.LoginInvalidoException;
import com.labanta.servidorlocal.models.ServicoModel;
import com.labanta.servidorlocal.models.Utilizador;
import com.labanta.servidorlocal.repository.UtilizadorRepository;
import com.labanta.servidorlocal.security.JwtService;
import com.labanta.servidorlocal.service.AuthService;
import com.labanta.servidorlocal.service.ServicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthController {
    private final JwtService jwtService;
    private final AuthService authService;
    private final ServicoService servicoService;
    private final UtilizadorRepository utilizadorRepository;

    public AuthController(JwtService jwtService, AuthService authService, ServicoService servicoService, UtilizadorRepository utilizadorRepository ) {
        this.jwtService = jwtService;
        this.authService = authService;
        this.servicoService = servicoService;
        this.utilizadorRepository = utilizadorRepository;
    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {

        Optional<Utilizador> utilizador =
                utilizadorRepository.findByUsername(request.getUsername());

        if (utilizador.isEmpty()) {
            throw new LoginInvalidoException("Username ou password inválidos");
        }

        if (!utilizador.get().getPassword().equals(request.getPassword())) {
            throw new LoginInvalidoException("Username ou password inválidos");
        }

        String token = jwtService.gerarToken(request.getUsername());

        return ResponseEntity.ok(token);
    }
    @PostMapping("/registar")
    public ResponseEntity<Utilizador> registar(
            @RequestBody RegistoRequestDTO dados) {

        Utilizador utilizador = authService.registarUtilizador(dados);

        return ResponseEntity.ok(utilizador);
    }
    @GetMapping("/api/v1/servicos/pesquisa")
    public List<ServicoModel> pesquisarServicos(
            @RequestParam String termo) {

        return servicoService.pesquisarServicos(termo);
    }
}
