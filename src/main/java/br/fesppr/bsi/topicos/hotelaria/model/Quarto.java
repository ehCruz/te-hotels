package br.fesppr.bsi.topicos.hotelaria.model;

import br.fesppr.bsi.topicos.hotelaria.model.enums.Disponibilidade;
import br.fesppr.bsi.topicos.hotelaria.model.enums.TipoQuarto;

public class Quarto {

    private boolean hasBerco;
    private Disponibilidade disponibilidade = Disponibilidade.DISPONIVEL;
    private final TipoQuarto tipoQuarto;
    private final Hotel hotel;

    public Quarto(TipoQuarto tipoQuarto, Hotel hotel) {
        this.hotel = hotel;
        this.tipoQuarto = tipoQuarto;
    }

    public Boolean getHasBerco() {
        return hasBerco;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void adicionarBerco() {
        this.hasBerco = true;
    }

    public void ocupar() {
        if (Disponibilidade.DISPONIVEL.equals(this.disponibilidade)) {
            this.disponibilidade = Disponibilidade.OCUPADO;
        }
    }

    public void indisponibilizar() {
        if (Disponibilidade.DISPONIVEL.equals(this.disponibilidade)) {
            this.disponibilidade = Disponibilidade.INDISPONIVEL;
        }
    }

    public void chekOut() {
        if (Disponibilidade.OCUPADO.equals(this.disponibilidade)) {
            this.hasBerco = false;
            this.disponibilidade = Disponibilidade.INDISPONIVEL;
        }
    }

    public void fechar() {
        if (Disponibilidade.INDISPONIVEL.equals(this.disponibilidade)) {
            this.disponibilidade = Disponibilidade.FECHADO;
        }
    }

    public void liberar() {
        if (Disponibilidade.INDISPONIVEL.equals(this.disponibilidade) || Disponibilidade.FECHADO.equals(this.disponibilidade)) {
            this.disponibilidade = Disponibilidade.DISPONIVEL;
        }
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public Hotel getHotel() {
        return hotel;
    }
}
