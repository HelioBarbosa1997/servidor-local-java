package core;

import model.Servico;
import model.Pessoa;
import model.Vendedor;
import utils.Formatador;
import utils.ExportadorDados;




public class Main {
    public static void main(String[] args) {
        Formatador formatador = new Formatador();

        Servico desenvolvidor = new Servico("Desenvolvidor ", "Fazer um website completo", 2000.00, true);
        Servico design = new Servico("Todo tipo de design imaginavel", "Criacao de um logotipos", 500.0, true);

        formatador.imprimirServico(desenvolvidor);
        formatador.imprimirServico(design);

        Pessoa Antonio = new Pessoa("Antonio", "Ponta d agua", 22, 500.00);
        Pessoa Joao = new Pessoa("Joao", "Achada Sao Felipe", 21, 1000.00);

        formatador.imprimirPessoa(Antonio);
        formatador.imprimirPessoa(Joao);

                                                // exercicio 6
        Pessoa cliente = new Pessoa("Ana", "Ponta d agua",28, 2000.00);

        Servico servico1 = new Servico("Canalizador", "Manutençao", 150.0, true);
        Servico servico2 = new Servico("Pintor", "Pintura", 250.0, true);
        Servico servico3 = new Servico("Técnico", "Manutenção computadores", 80.0, true);

        // 3. Adicionar os 3 serviços ao carrinho da pessoa
        cliente.servicosComprados.add(servico1);
        cliente.servicosComprados.add(servico2);
        cliente.servicosComprados.add(servico3);


        ExportadorDados exportador = new ExportadorDados();

        System.out.println("--- Exportando Carrinho para JSON ---");
        exportador.exportarCarrinhosParaJson(cliente);
    }
}



