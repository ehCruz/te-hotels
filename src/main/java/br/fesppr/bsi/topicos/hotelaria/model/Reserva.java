package br.fesppr.bsi.topicos.hotelaria.model;

import br.fesppr.bsi.topicos.hotelaria.exceptions.HotelariaException;
import br.fesppr.bsi.topicos.hotelaria.exceptions.ReservaException;
import br.fesppr.bsi.topicos.hotelaria.model.enums.TipoQuarto;
import br.fesppr.bsi.topicos.hotelaria.model.enums.TipoRefeicao;
import br.fesppr.bsi.topicos.hotelaria.pagamento.model.Pagamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {

	private LocalDate entrada;
	private LocalDate saida;
	private boolean precisaBerco;
	private BigDecimal valorReserva;
	private boolean cancelado;

	private TipoQuarto tipoQuarto;
	private Hospede titular;
	private List<Hospede> dependentes = new ArrayList<>();
	private Estadia estadia;
	private Hotel hotel;
	private List<Pagamento> pagamentos = new ArrayList<>();
	private List<TipoRefeicao> refeicoes = new ArrayList<>();

	public Reserva(Hospede titular, TipoQuarto tipoQuarto, Hotel hotel) throws HotelariaException {
		if (titular == null) {
			throw new HotelariaException("Hospede não pode ser nulo.");
		}
		this.titular = titular;
		this.tipoQuarto = tipoQuarto;
		this.hotel = hotel;
	}

	public void solicitarReserva(LocalDate entrada, LocalDate saida) throws ReservaException {
		if (entrada != null && saida != null) {
			if (entrada.isBefore(LocalDate.now())) {
				throw new ReservaException("A data de entrada não pode ser anterior a data atual.");
			}
			if (saida.isBefore(entrada)) {
				throw new ReservaException("A data de saida não pode ser anterior a data de entrada.");
			}
			this.entrada = entrada;
			this.saida = saida;
			this.enviarEmailConfirmacao();
		} else {
			throw new ReservaException("Informe uma data de reserva válida.");
		}
	}

	public void solicitarBerco() {
		this.precisaBerco = true;
	}

	public void pagar(Pagamento formaPagamento) {
		// TODO fazer com que pagamento mínimo seja de 30% do valor da reserva
		formaPagamento.setReserva(this);
		formaPagamento.pagar(this.valorReserva);
		this.pagamentos.add(formaPagamento);
	}

	public void cancelarReserva() throws ReservaException {
		if (this.estadia == null) {
			this.cancelado = true;
			// TODO - devolver pagamento
		}
		throw new ReservaException("Não é possível cancelar uma reserva após o checkin.");
	}

	public void realizarCheckIn() {
		this.estadia = new Estadia(this);
	}

	public void adicionarDependente(Hospede dependente) {
		if (dependente != null) {
			dependente.getDependente().setPermissao(false);
			this.dependentes.add(dependente);
		}
	}

	private void enviarEmailConfirmacao() {
		// TODO - envio de email
	}

	public LocalDate getEntrada() {
		return entrada;
	}

	public LocalDate getSaida() {
		return saida;
	}

	public boolean isPrecisaBerco() {
		return precisaBerco;
	}

	public BigDecimal getValorReserva() {
		return valorReserva;
	}

	public boolean isCancelada() {
		return cancelado;
	}

	public TipoQuarto getTipoQuarto() {
		return tipoQuarto;
	}

	public Hospede getTitular() {
		return titular;
	}

	public Estadia getEstadia() {
		return estadia;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public List<TipoRefeicao> getRefeicoes() {
		return refeicoes;
	}

	public List<Hospede> getDependentes() {
		return dependentes;
	}

}
