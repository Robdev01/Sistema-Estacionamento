package models;

public abstract class Veiculo {

    protected String placa;
    protected long horarioEntrada;

    public Veiculo(String placa) {
        this.placa = placa;
        this.horarioEntrada = System.currentTimeMillis();
    }

    public String getPlaca() {
        return placa;
    }

    public long getHorarioEntrada() {
        return horarioEntrada;
    }

    public abstract String getTipo();
}
