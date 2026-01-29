package models;

public class Ticket {

    private Veiculo veiculo;
    private long horarioSaida;
    private double valorPago;

    public Ticket(Veiculo veiculo, double valorPago) {
        this.veiculo = veiculo;
        this.horarioSaida = System.currentTimeMillis();
        this.valorPago = valorPago;
    }

    public double getValorPago() {
        return valorPago;
    }

    @Override
    public String toString() {
        return "Placa: " + veiculo.getPlaca() +
                " | Tipo: " + veiculo.getTipo() +
                " | Valor: R$ " + valorPago;
    }
}
