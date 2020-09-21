package br.fesppr.bsi.topicos.hotelaria.model;

import br.fesppr.bsi.topicos.hotelaria.model.utils.pagamento.FormaPagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pagamento {

    private LocalDateTime dataPagamento;
    private BigDecimal valorPago;
    private FormaPagamento formaPagamento;

    public Pagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void pagar(BigDecimal valor) {
        this.valorPago = valor;
        this.dataPagamento = LocalDateTime.now();
        this.formaPagamento.executarPagamento();
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }
}
