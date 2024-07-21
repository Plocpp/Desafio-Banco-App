package Banco;

public class ContaPoupanca extends Conta {
    private static int contadorAgencia = 1001; // Começando de 1001 para diferenciar de ContaCorrente
    private double taxaDeRendimento;

    public ContaPoupanca(int numero, Cliente cliente, double taxaDeRendimento) {
        super(numero, contadorAgencia++, cliente);
        this.taxaDeRendimento = taxaDeRendimento;
    }

    public void aplicarRendimento() {
        double rendimento = saldo * taxaDeRendimento;
        saldo += rendimento;
        extrato.add(new Transacao("Rendimento aplicado", rendimento, saldo));
    }
}
