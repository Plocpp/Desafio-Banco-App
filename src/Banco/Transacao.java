package Banco;

import java.time.LocalDateTime;

public class Transacao {
    private LocalDateTime dataHora;
    private String tipo;
    private double valor;
    private double saldoApos;

    public Transacao(String tipo, double valor, double saldoApos) {
        this.dataHora = LocalDateTime.now();
        this.tipo = tipo;
        this.valor = valor;
        this.saldoApos = saldoApos;
    }

    public String toString() {
        return dataHora + " - " + tipo + ": " + valor + " | Saldo após: " + saldoApos;
    }
}
