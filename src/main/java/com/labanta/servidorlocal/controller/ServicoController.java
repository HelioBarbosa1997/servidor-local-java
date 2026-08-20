package com.labanta.servidorlocal.controller;

import com.labanta.servidorlocal.models.ServicoModel;
import com.labanta.servidorlocal.repository.ServicoRepository;
import com.labanta.servidorlocal.service.ServicoService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/auth/servicos")
public class ServicoController {
    private final ServicoRepository repository;
    private final ServicoService servicoService;

    public ServicoController(ServicoRepository repository) {
        this.repository = repository;
        this.servicoService = new ServicoService(repository);
    }
    /*
    @GetMapping("/teste")

        public String dizerOla() {
            return "Ola mundo! O meu servidor spring esta a funcionar";

        }

        @GetMapping
        public List<ServicoModel> listarServicos() {


            return repository.findAll();
        }
*/
        @GetMapping
        public List<ServicoModel> listarServico() {
            return repository.findAll();

        }


        @PostMapping()
        public ServicoModel criarServico(@RequestBody ServicoModel novoServico) {
            return repository.save(novoServico);

        }
            //Exercicio 11
        @GetMapping("/{id}")
        public ServicoModel buscarServicoPorId(@PathVariable Long id) {
            return servicoService.buscarServicoPorId(id);

    }
    //exercicio 13
        @GetMapping("/pesquisa")
        public List<ServicoModel> pesquisarServicos(
            @RequestParam String termo) {

        return servicoService.pesquisarServicos(termo);
    }

}
