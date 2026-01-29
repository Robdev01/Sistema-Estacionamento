package service;

import interfaces.Estacionavel;
import models.*;
import repository.VeiculoRepository;

import java.util.ArrayList;
import java.util.List;

public class EstacionamentoService implements Estacionavel {

    private final VeiculoRepository repository = new VeiculoRepository();
    private final CalculadoraPrecoService calculadora = new CalculadoraPrecoService();

    private final List<Ticket> tickets = new ArrayList<>();
    private double faturamento = 0.0;

    public void entrada(String tipo, String placa) {

        Veiculo veiculo = tipo.equalsIgnoreCase("MOTO")
                ? new Moto(placa)
                : new Carro(placa);

        registrarEntrada(veiculo);
    }

    @Override
    public void registrarEntrada(Veiculo veiculo) {
        repository.salvar(veiculo);
        System.out.println("Entrada registrada com sucesso!");
    }

    @Override
    public Veiculo registrarSaida(String placa) {

        Veiculo veiculo = repository.buscarPorPlaca(placa);
        if (veiculo == null) {
            System.out.println("Veículo não encontrado!");
            return null;
        }

        long saida = System.currentTimeMillis();
        double valor = calculadora.calcular(
                veiculo.getHorarioEntrada(),
                saida,
                veiculo.getTipo()
        );

        faturamento += valor;
        tickets.add(new Ticket(veiculo, valor));
        repository.remover(veiculo);

        System.out.println("Saída registrada. Valor a pagar: R$ " + valor);
        return veiculo;
    }

    public void listarVeiculos() {
        if (repository.listar().isEmpty()) {
            System.out.println("Nenhum veículo estacionado.");
            return;
        }

        repository.listar()
                .forEach(v ->
                        System.out.println(v.getTipo() + " - " + v.getPlaca())
                );
    }

    public double getFaturamento() {
        return faturamento;
    }
}
