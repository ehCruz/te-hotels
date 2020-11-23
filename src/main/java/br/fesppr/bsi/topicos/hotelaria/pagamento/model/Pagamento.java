package br.fesppr.bsi.topicos.hotelaria.pagamento.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.fesppr.bsi.topicos.hotelaria.model.Reserva;

public abstract class Pagamento {

	private LocalDateTime dataPagamento;
	private BigDecimal valorMonetario;
	private Reserva reserva;

	public abstract void pagar(BigDecimal valorMonetario);

	protected BigDecimal conversaoMonetaria(String moeda) {
		// TODO conversao de moeda
		return null;
	}

	public LocalDateTime getDataPagamento() {
		return dataPagamento;
	}

	public BigDecimal getValorMonetario() {
		return valorMonetario;
	}

	public void setValorMonetario(BigDecimal valorMonetario) {
		this.valorMonetario = valorMonetario;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}
