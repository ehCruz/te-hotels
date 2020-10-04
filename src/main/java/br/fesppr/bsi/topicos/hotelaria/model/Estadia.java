package br.fesppr.bsi.topicos.hotelaria.model;

import br.fesppr.bsi.topicos.hotelaria.exceptions.HotelariaException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estadia {

    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;
    private Reserva reserva;
    private Quarto quarto;
    private List<Gasto> gastos = new ArrayList<>();

    public Estadia(Reserva reserva) {
        this.reserva = reserva;
        this.horaEntrada = LocalDateTime.now();
        this.ocuparQuarto();
    }

    public void realizarCheckOut() {
        this.quarto.chekOut();
        this.horaSaida = LocalDateTime.now();
        // TODO pagamento
    }

    public void adicionarGasto(Gasto gasto) {
        if (gasto != null) {
            gasto.setEstadia(this);
            this.gastos.add(gasto);
        }
    }

    private void ocuparQuarto() {
        try {
            this.quarto = this.reserva.getHotel().getQuartoDisponivelFromTipo(reserva.getTipoQuarto());
            this.quarto.ocupar();
        } catch (HotelariaException ex) {
            // TODO tratar excecao
        }
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalDateTime horaSaida) {
        this.horaSaida = horaSaida;
    }
}
