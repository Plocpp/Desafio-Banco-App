package Banco;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    private int numero;
    private int agencia;
    private Cliente cliente;
    protected double saldo;
    protected List<Transacao> extrato;

    public Conta(int numero, int agencia, Cliente cliente) {
        this.numero = numero;
        this.agencia = agencia;
        this.cliente = cliente;
        this.saldo = 0.0;
        this.extrato = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        extrato.add(new Transacao("Depósito", valor, saldo));
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            extrato.add(new Transacao("Saque", valor, saldo));
            return true;
        }
        return false;
    }

    public boolean transferir(Conta destino, double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
            extrato.add(new Transacao("Transferência para conta " + destino.getNumero(), valor, saldo));
            return true;
        }
        return false;
    }

    public void exibirExtrato() {
        System.out.println("Extrato da conta " + numero + " de " + cliente.getNome() + ":");
        for (Transacao transacao : extrato) {
            System.out.println(transacao);
        }
    }
}
