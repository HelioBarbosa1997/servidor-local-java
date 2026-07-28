//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Servico {
    String titulo;
    String descricao;
    Double preco;
    Boolean estrativo;

    public Servico(String novoTitulo, String novoDiscricao, Double novoPreco, Boolean novoEstrativo) {
        this.titulo = novoTitulo;
        this.descricao = novoDiscricao;
        this.preco = novoPreco;
        this.estrativo = novoEstrativo;
    }
}

class Pessoa {
    String nome;
    String morada;
    int idade;

    public Pessoa(String novoNome, String novaMorada, int novaIdade) {
        this.nome = novoNome;
        this.morada = novaMorada;
        this.idade = novaIdade;
    }
};

public class Main {
    public static void main(String[] args) {
        Servico Servico = new Servico("Desenvolvidor Full Stack", "Criar e executar aplicações web e moveis",120.00, true);

        System.out.println("------------------ Servico --------------------------");
        System.out.println("titulo : " + Servico.titulo);
        System.out.println("Discricao: " + Servico.descricao);
        System.out.println("preco : " + Servico.preco);
        System.out.println("estado: " + Servico.estrativo);

        Servico Servico1 = new Servico("Manutencao CPU", "tecnico", 12.11,true);

        System.out.println("------------------ Servico1 -------------------------");
        System.out.println("titulo : " + Servico1.titulo);
        System.out.println("Discricao: " + Servico1.descricao);
        System.out.println("preco : " + Servico1.preco);
        System.out.println("estado: " + Servico1.estrativo);

        Pessoa pessoa1 = new Pessoa("Helio", "Ponta d´ água", 29);

        System.out.println("----------------- Pessoa1 --------------------");
        System.out.println("nome da pessoa1: " + pessoa1.nome);
        System.out.println("morada da pessoa1: " + pessoa1.morada );
        System.out.println("idade da pessoa1: " + pessoa1.idade);
        System.out.println("--------------------------------------------");

        System.out.println("-------- Simulação de Compra ----------");
        System.out.println("O " + pessoa1.nome + " comprou o serviço " + Servico1.titulo + " por " + Servico1.preco + " CVE.");

        System.out.println("--------------------------------------------");
        System.out.println("Hello Word");
        String nome  = "Helio Barbosa";
        String morada = "Ponta d agua";
        int idade = 29;

        System.out.println("Nome: " + nome);
        System.out.println("Morada: " + morada);
        System.out.println("Idade: " + idade);


    }

}