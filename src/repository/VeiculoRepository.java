package repository;

import models.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoRepository {

    private final List<Veiculo> veiculos = new ArrayList<>();

    public void salvar(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public Veiculo buscarPorPlaca(String placa) {
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    public void remover(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public List<Veiculo> listar() {
        return veiculos;
    }
}
