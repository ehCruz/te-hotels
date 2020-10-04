package br.fesppr.bsi.topicos.hotelaria.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Gasto {

    private String descricao;
    private LocalDateTime dataRequisicao;
    private BigDecimal valor;
    private boolean isCancelado;
    private Estadia estadia;

    public Gasto() {
        this.dataRequisicao = LocalDateTime.now();
    }

    public void cancelarServico() {
        this.isCancelado = true;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataRequisicao() {
        return dataRequisicao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public boolean isCancelado() {
        return isCancelado;
    }

    public Estadia getEstadia() {
        return estadia;
    }

    public void setEstadia(Estadia estadia) {
        if(estadia != null) {
            this.estadia = estadia;
        }
    }
}
