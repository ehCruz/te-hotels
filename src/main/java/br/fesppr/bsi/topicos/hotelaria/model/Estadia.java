package br.fesppr.bsi.topicos.hotelaria.model;

import br.fesppr.bsi.topicos.hotelaria.exceptions.HotelariaException;
import br.fesppr.bsi.topicos.hotelaria.model.enums.TipoRefeicao;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Estadia {

	private LocalTime entrada;
	private LocalTime saida;

	private Reserva reserva;
	private Quarto quarto;
	private List<Gasto> gastos = new ArrayList<>();
	private List<TipoRefeicao> refeicoes = new ArrayList<>();

	public Estadia(Reserva reserva) {
		this.reserva = reserva;
		this.entrada = LocalTime.now();
		this.ocuparQuarto();
	}

	public void realizarCheckOut() {
		this.quarto.chekOut();
		this.saida = LocalTime.now();
		// TODO pagamento
	}

	public void adicionarGasto(Gasto gasto) {
		if (gasto != null) {
			gasto.setEstadia(this);
			this.gastos.add(gasto);
		}
	}

	private void ocuparQuarto() {
		try {
			this.quarto = this.reserva.getHotel().getQuartoDisponivelFromTipo(reserva.getTipoQuarto());
			this.quarto.ocupar();
		} catch (HotelariaException ex) {
			// TODO tratar excecao
		}
	}

	public void novaRefeicao(TipoRefeicao refeicao) {
		if (refeicao != null) {
			this.refeicoes.add(refeicao);
		}
	}

	public LocalTime getEntrada() {
		return entrada;
	}

	public LocalTime getSaida() {
		return saida;
	}

}
