package Banco;

public class BancoDigitalApp {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("João Silva", "123.456.789-00");
        Cliente cliente2 = new Cliente("Maria Souza", "987.654.321-00");

        Conta conta1 = new ContaCorrente(1, cliente1, 5.0);
        Conta conta2 = new ContaPoupanca(2, cliente2, 0.03);

        // Realizando operações
        conta1.depositar(1000.0);
        conta2.depositar(500.0);

        conta1.transferir(conta2, 200.0);

        // Aplicar rendimento na poupança
        ((ContaPoupanca) conta2).aplicarRendimento();

        // Exibindo extrato
        conta1.exibirExtrato();
        conta2.exibirExtrato();
    }
}
