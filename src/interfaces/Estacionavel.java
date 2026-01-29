package interfaces;

import models.Veiculo;

public interface Estacionavel {

    void registrarEntrada(Veiculo veiculo);
    Veiculo registrarSaida(String placa);
}
