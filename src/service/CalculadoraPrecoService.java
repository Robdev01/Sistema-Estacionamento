package service;

import interfaces.Precificavel;

public class CalculadoraPrecoService implements Precificavel {

    @Override
    public double calcular(long entrada, long saida, String tipoVeiculo) {

        double horas = Math.ceil((saida - entrada) / 3600000.0);

        return switch (tipoVeiculo) {
            case "MOTO" -> horas * 5;
            case "CARRO" -> horas * 10;
            default -> horas * 12;
        };
    }
}
