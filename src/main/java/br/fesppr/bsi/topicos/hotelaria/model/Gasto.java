package br.fesppr.bsi.topicos.hotelaria.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Gasto {

    private String descricao;
    private LocalDateTime dataRequisicao;
    private BigDecimal valor;
    private boolean isCancelado;
    private Estadia estadia;

    public Gasto(String descricao, LocalDateTime dataRequisicao, BigDecimal valor) {
        this.descricao = descricao;
        this.dataRequisicao = dataRequisicao;
        this.valor = valor;
    }

    public void cancelarServico() {
        this.isCancelado = true;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataRequisicao() {
        return dataRequisicao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public boolean isCancelado() {
        return isCancelado;
    }

    public void setEstadia(Estadia estadia) {
        if(estadia != null) {
            this.estadia = estadia;
        }
    }

    public Estadia getEstadia() {
        return estadia;
    }
}
