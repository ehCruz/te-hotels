package br.fesppr.bsi.topicos.hotelaria.pagamento.model;

import java.math.BigDecimal;

public class Dinheiro extends Pagamento {

	@Override
	public void pagar(BigDecimal valorPagamaento) {
		// TODO realizar pagamento
		setValorMonetario(valorPagamaento);
	}

}
