package br.fesppr.bsi.topicos.hotelaria.model;

import br.fesppr.bsi.topicos.hotelaria.model.enums.Disponibilidade;
import br.fesppr.bsi.topicos.hotelaria.model.enums.TipoQuarto;
import br.fesppr.bsi.topicos.hotelaria.model.enums.TipoServico;

public class Quarto {

    private boolean berco;
    
    private Disponibilidade disponibilidade = Disponibilidade.DISPONIVEL;
    private TipoQuarto tipoQuarto;
    private Hotel hotel;
    private Servico servico;

    public Quarto(TipoQuarto tipoQuarto, Hotel hotel) {
        this.hotel = hotel;
        this.tipoQuarto = tipoQuarto;
    }

    public Boolean hasBerco() {
        return berco;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void adicionarBerco() {
        this.berco = true;
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
            this.berco = false;
            this.disponibilidade = Disponibilidade.INDISPONIVEL;
            this.servicoQuarto(TipoServico.HIGIENE);
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
    
    public void servicoQuarto(TipoServico tipoServico) {
    	this.servico = new Servico(tipoServico);
        this.servico.setQuarto(this);
        this.servico.solicitarServicoDeQuarto();
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public Hotel getHotel() {
        return hotel;
    }
}
