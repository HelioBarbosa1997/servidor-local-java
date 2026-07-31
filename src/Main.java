import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Servico {
    private String titulo;
    private String descricao;
    private Double preco;
    private Boolean estaAtivo;

    public Servico(String novoTitulo, String novoDiscricao, Double novoPreco, Boolean novoEstaAtivo) {
        this.titulo = novoTitulo;
        this.descricao = novoDiscricao;
        this.preco = novoPreco;
        this.estaAtivo = novoEstaAtivo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo() {
        return this.titulo;
    }
    public void setDescricao( String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return this.descricao;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public double getPreco() {
        return this.preco;
    }
    public void setEstaAtivo (boolean estaAtivo) {
        this.estaAtivo = estaAtivo;
    }
    public boolean getEstaAtivo () {
        return this.estaAtivo;
    }

    public void aplicarDesconto(double percentagem) {
        double valorDesconto = (this.preco * percentagem) / 100;
        this.preco = this.preco - valorDesconto;

        System.out.println("------------- Desconto ---------------");
        System.out.println("Desconto Aplicado com sucesso");
        System.out.println("valor final: " + this.preco);
    }
    public void verificarDisponibilidade() {
        if (this.estaAtivo) {
            System.out.println("Servico " + this.titulo + " esta disponivel");
        } else {
            System.out.println("Servico " + this.titulo + " nao esta disponivel");
        }
    }
}

class Pessoa {
    private String nome;
    private String morada;
    private int idade;
    private Double saldo;

    List<Servico> servicosComprado;

    public Pessoa(String novoNome, String novaMorada, int novaIdade, Double novoSaldo) {
        this.nome = novoNome;
        this.morada = novaMorada;
        this.idade = novaIdade;
        this.saldo = novoSaldo;
        this.servicosComprado = new ArrayList<>();
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return this.nome;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }
    public String getMorada() {
        return this.morada;
    }

    public void setIdade(String morada) {
        this.morada = morada;
    }
    public int getIdade() {
        return this.idade;
    }

    public  void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public double getSaldo() {
        return this.saldo;
    }


    public void comprarServico(Double saldo, Servico servicoEscolhido) throws Exception {
        if (this.saldo < servicoEscolhido.getPreco() || !servicoEscolhido.getEstaAtivo() == true) {

            System.out.println("Erro: Saldo insuficiente ou serviço inativo.");
            throw  new Exception("Erro insuficiente ou Servico inativo");
        }

        this.saldo -= servicoEscolhido.getPreco();
        this.servicosComprado.add(servicoEscolhido);
        System.out.println("Compra efetuada com sucesso");
    }

    public void mostrarHistorico() {
        System.out.println("----------Lista de servicos comprados--------------");
        for(Servico s: this.servicosComprado){
            System.out.println("Servico: " + s.getTitulo());
        }
    }
};
class ServicoDigital extends Servico {
    String linkDownload;

    public ServicoDigital(String titulo, String descricao, double preco, boolean estaAtivo) {
        super (titulo, descricao, preco, estaAtivo);
        this.linkDownload = linkDownload;
    }
}
class Vendedor extends Pessoa {
    Double taxaComissao;
    public Vendedor(String nome, String morada, int telefone, double saldo , double taxaComissao) {
        super(nome, morada, telefone, saldo);
        this.taxaComissao = taxaComissao;
    }
    public double getTaxaComissao() {
        return taxaComissao;
    }
}

public class Main {
    public static void main(String[] args) {
        Servico Servico = new Servico("Desenvolvidor Full Stack", "Criar e executar aplicações web e moveis",120.00, true);

        System.out.println("------------------ Servico --------------------------");
        System.out.println("titulo : " + Servico.getTitulo());
        System.out.println("Discricao: " + Servico.getDescricao());
        System.out.println("preco : " + Servico.getPreco());
        System.out.println("estado: " + Servico.getEstaAtivo());

        Servico servico1 = new Servico("Manutencao CPU", "tecnico", 12.11,true);

        System.out.println("------------------ Servico1 -------------------------");
        System.out.println("titulo : " + servico1.getTitulo());
        System.out.println("Discricao: " + servico1.getDescricao());
        System.out.println("preco : " + servico1.getPreco());
        System.out.println("estado: " + servico1.getEstaAtivo());

        servico1.aplicarDesconto(10);

        servico1.verificarDisponibilidade();

        Pessoa pessoa1 = new Pessoa("Helio", "Ponta d´ água", 29, 20000.0);

        Vendedor vendedor = new Vendedor("Augusto","achadinha", 9877656, 200, 1222);

        Servico servicoEscolhido = new Servico("Pintor", "realizar pinturas", 1500.0, true);

        try {
            pessoa1.comprarServico(pessoa1.getSaldo(), servicoEscolhido);
        } catch (Exception e) {
            System.out.println("Ocorreu o seguinte erro: " + e.getMessage());
        }


        System.out.println("----------------- Pessoa1 --------------------");
        System.out.println("nome da pessoa1: " + pessoa1.getNome());
        System.out.println("morada da pessoa1: " + pessoa1.getMorada() );
        System.out.println("idade da pessoa1: " + pessoa1.getIdade());
        System.out.println("--------------------------------------------");

        System.out.println("----------- Vendedor ---------------");
        System.out.println("Nome: " + vendedor.getNome());
        System.out.println("Morada: " + vendedor.getMorada());
        System.out.println("Idade: " + vendedor.getIdade());
        System.out.println("Saldo: " + vendedor.getSaldo());
        System.out.println("Taxa de comissão = " + vendedor.getTaxaComissao());

        System.out.println("--------  Compra ----------");
        System.out.println("O " + pessoa1.getNome() + " comprou o serviço " + servico1.getTitulo() + " por " + servico1.getPreco() + " CVE.");

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
