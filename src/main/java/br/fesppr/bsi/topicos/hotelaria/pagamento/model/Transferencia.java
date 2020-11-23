package br.fesppr.bsi.topicos.hotelaria.pagamento.model;

import java.math.BigDecimal;

public class Transferencia extends Pagamento {

	private String contaOrigem;
	private String contaDestino;
	private String cpfContaOrigem;
	private String cnpjContaDestino;

	@Override
	public void pagar(BigDecimal valorPagamaento) {
		// TODO realizar pagamento
		setValorMonetario(valorPagamaento);
	}

	public String getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public String getCpfContaOrigem() {
		return cpfContaOrigem;
	}

	public void setCpfContaOrigem(String cpfContaOrigem) {
		this.cpfContaOrigem = cpfContaOrigem;
	}

	public String getCnpjContaDestino() {
		return cnpjContaDestino;
	}

	public void setCnpjContaDestino(String cnpjContaDestino) {
		this.cnpjContaDestino = cnpjContaDestino;
	}

}
