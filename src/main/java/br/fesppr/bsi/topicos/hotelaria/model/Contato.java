package br.fesppr.bsi.topicos.hotelaria.model;

public class Contato {

    private String tipoContato;
    private String valor;
    private final Hotel hotel;

    public Contato(String tipoContato, String valor, Hotel hotel) {
        this.tipoContato = tipoContato;
        this.valor = valor;
        this.hotel = hotel;
    }

    public String getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(String tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
