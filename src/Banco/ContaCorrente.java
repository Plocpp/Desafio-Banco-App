package Banco;

public class ContaCorrente extends Conta {
    private static int contadorAgencia = 1;
    private double taxaDeOperacao;

    public ContaCorrente(int numero, Cliente cliente, double taxaDeOperacao) {
        super(numero, contadorAgencia++, cliente);
        this.taxaDeOperacao = taxaDeOperacao;
    }

    @Override
    public boolean sacar(double valor) {
        double valorASacar = valor + taxaDeOperacao;
        return super.sacar(valorASacar);
    }

    @Override
    public boolean transferir(Conta destino, double valor) {
        double valorATransferir = valor + taxaDeOperacao;
        return super.transferir(destino, valorATransferir);
    }
}



