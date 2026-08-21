package com.labanta.servidorlocal.controller;

import com.labanta.servidorlocal.models.ServicoModel;
import com.labanta.servidorlocal.repository.ServicoRepository;
import com.labanta.servidorlocal.service.EmailService;
import com.labanta.servidorlocal.service.ExchangeService;
import com.labanta.servidorlocal.service.ServicoService;
import model.Servico;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/servicos")
public class ServicoController {
    private final ServicoRepository repository;
    private final ServicoService servicoService;
    private final ExchangeService exchangeService;
    private final EmailService emailService;

    public ServicoController(ServicoRepository repository, ExchangeService exchangeService, EmailService emailService) {
        this.repository = repository;
        this.servicoService = new ServicoService(repository);
        this.exchangeService = exchangeService;
        this.emailService = emailService;
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
    //aula 19
        @PostMapping("/{id}/ orcamneto")
        public String pedirOrcamento(@PathVariable Long id, @RequestParam String emailDestino, @RequestParam(defaultValue = "CVE") String moeda) {
            // 1. Ir à Base de Dados buscar o Serviço
            ServicoModel servico = servicoService.buscarServicoPorId(id);

            // 2. Ir à Internet converter o preço (Aula 16)
            Double precoConvertido = exchangeService.converterPreco(servico.getPreco(), moeda);

            // 3. Enviar o resultado para o Gmail do cliente (Aula 15)
            emailService.enviarOrcamentoPorEmail(emailDestino, servico.getTitulo(), precoConvertido, moeda);

            return "Orçamento calculado e enviado com sucesso para " + emailDestino + "!";
        }

}
