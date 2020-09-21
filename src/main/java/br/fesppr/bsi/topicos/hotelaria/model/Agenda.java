package br.fesppr.bsi.topicos.hotelaria.model;

import br.fesppr.bsi.topicos.hotelaria.model.enums.Disponibilidade;
import br.fesppr.bsi.topicos.hotelaria.model.enums.TipoQuarto;

import java.time.LocalDate;
import java.util.Objects;

public class Agenda {

    private Long tipoConforto01;
    private Long tipoConforto02;
    private Long tipoConforto03;
    private final LocalDate data;
    private final Hotel hotel;

    public Agenda(LocalDate data, Hotel hotel) {
        this.data = data;
        this.hotel = hotel;
        this.setDadosAgendaData();
    }

    public boolean isTipoQuartoDisponivel(TipoQuarto tipoQuarto) {
        if (tipoQuarto.getId() == 1) {
            return this.tipoConforto01 > 0;
        }
        if (tipoQuarto.getId() == 2) {
            return this.tipoConforto02 > 0;
        }
        return this.tipoConforto03 > 0;
    }

    public void adicionar(TipoQuarto tipoQuarto) {
        if (tipoQuarto.getId() == 1) {
            --this.tipoConforto01;
        }
        if (tipoQuarto.getId() == 2) {
            --this.tipoConforto02;
        }
        if (tipoQuarto.getId() == 3) {
            --this.tipoConforto03;
        }
    }

    private void setDadosAgendaData() {
        this.tipoConforto01 = this.hotel.getQuartos().stream()
                .filter(quarto -> this.filterQuarto(quarto, TipoQuarto.CONFORTO_01))
                .count();
        this.tipoConforto02 = this.hotel.getQuartos().stream()
                .filter(quarto -> this.filterQuarto(quarto, TipoQuarto.CONFORTO_02))
                .count();
        this.tipoConforto03 = this.hotel.getQuartos().stream()
                .filter(quarto -> this.filterQuarto(quarto, TipoQuarto.CONFORTO_03))
                .count();
    }

    private boolean filterQuarto(Quarto q, TipoQuarto t) {
        return q.getTipoQuarto().getId().equals(t.getId()) && q.getDisponibilidade().equals(Disponibilidade.DISPONIVEL);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agenda agenda = (Agenda) o;
        return data.equals(agenda.data) &&
                hotel.equals(agenda.hotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, hotel);
    }
}
