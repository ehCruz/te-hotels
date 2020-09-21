package br.fesppr.bsi.topicos.hotelaria.model;

import br.fesppr.bsi.topicos.hotelaria.model.enums.Disponibilidade;
import br.fesppr.bsi.topicos.hotelaria.model.enums.TipoQuarto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Estadia {

    private Reserva reserva;
    private Quarto quarto;
    private List<Gasto> gastos = new ArrayList<>();

    public Estadia(Reserva reserva) {
        this.reserva = reserva;
        this.ocuparQuarto();
    }

    public void realizarCheckOut() {
        this.quarto.chekOut();
        this.reserva.setHoraSaida(LocalDateTime.now());
        // TODO pagamento
    }

    public void adicionarGasto(Gasto gasto) {
        if(gasto != null) {
            gasto.setEstadia(this);
            this.gastos.add(gasto);
        }
    }

    private void ocuparQuarto() {
        this.quarto = this.reserva.getHotel().getQuartos()
                .stream().filter(q -> q.getDisponibilidade().equals(Disponibilidade.DISPONIVEL) && q.getTipoQuarto().equals(reserva.getTipoQuarto()))
                .collect(Collectors.toList()).get(0);
        this.quarto.ocupar();
    }
}
