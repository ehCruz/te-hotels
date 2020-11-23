package br.fesppr.bsi.topicos.hotelaria.pagamento.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CartaoDebito extends Cartao {

	public CartaoDebito(String numeroCartao, String bandeira, String nomeTitular, LocalDate dataValidade) {
		super(numeroCartao, bandeira, nomeTitular, dataValidade);
		// TODO tratamento de informações
	}

	@Override
	public void pagar(BigDecimal valorPagamaento) {
		// TODO realizar pagamento
	}

}
