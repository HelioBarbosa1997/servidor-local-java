package com.labanta.servidorlocal.service;

import com.labanta.servidorlocal.dto.LoginRequestDTO;
import com.labanta.servidorlocal.dto.RegistoRequestDTO;
import com.labanta.servidorlocal.exception.LoginInvalidoException;
import com.labanta.servidorlocal.exception.UtilizadorExistenteException;
import com.labanta.servidorlocal.models.Utilizador;
import com.labanta.servidorlocal.repository.UtilizadorRepository;
import com.labanta.servidorlocal.security.JwtService;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UtilizadorRepository utilizadorRepository;
    private final JwtService jwtService;

    public AuthService(UtilizadorRepository utilizadorRepository, JwtService jwtService) {
        this.utilizadorRepository = utilizadorRepository;
        this.jwtService = jwtService;

    }

    public Utilizador registarUtilizador(RegistoRequestDTO dados) {

        if (utilizadorRepository.findByUsername(dados.getUsername()).isPresent()) {
            throw new UtilizadorExistenteException("Este username já está em uso, por favor escolha outro.");
        }
        Utilizador utilizador = new Utilizador(
                dados.getUsername(),
                dados.getPassword(),
                dados.getEmail()
        );

        return utilizadorRepository.save(utilizador);
    }
    public String login(LoginRequestDTO dados) {

        Utilizador utilizador = utilizadorRepository
                .findByUsername(dados.getUsername())
                .orElseThrow(() ->
                        new LoginInvalidoException("Username ou password inválidos."));

        if (!utilizador.getPassword().equals(dados.getPassword())) {

            throw new LoginInvalidoException("Username ou password inválidos.");
        }

        return jwtService.gerarToken(utilizador.getUsername());
    }
}
