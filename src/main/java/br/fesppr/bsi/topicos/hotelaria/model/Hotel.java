package br.fesppr.bsi.topicos.hotelaria.model;

import br.fesppr.bsi.topicos.hotelaria.exceptions.HotelariaException;
import br.fesppr.bsi.topicos.hotelaria.model.enums.Disponibilidade;
import br.fesppr.bsi.topicos.hotelaria.model.enums.TipoQuarto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hotel {

	private String nomeFantasia;
	private String cnpj;
	private String regrasHotel;
	private String telefone;
	private String email;
	
	private Endereco endereco;
	private List<Agenda> agenda = new ArrayList<>();
	private List<Reserva> reservas = new ArrayList<>();
	private List<Quarto> quartos = new ArrayList<>();
	private List<Funcionario> funcionarios = new ArrayList<>();

	public Hotel(String nomeFantasia, String cnpj, Endereco endereco) {
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.endereco = endereco;
	}

	public void validarDisponibilidade(Reserva reserva) throws HotelariaException {
		LocalDate dataVerificacao = reserva.getEntrada();
		TipoQuarto tipoQuarto = reserva.getTipoQuarto();

		Agenda agendaTemp;
		List<Agenda> agendaCopy = new ArrayList<>(this.agenda);
		boolean isPeriodoDisponivel = true;
		while (dataVerificacao.isBefore(reserva.getSaida())) {
			agendaTemp = new Agenda(dataVerificacao, this);
			if (agendaCopy.contains(agendaTemp)) {
				agendaTemp = agendaCopy.get(agendaCopy.indexOf(agendaTemp));
				isPeriodoDisponivel = agendaTemp.isTipoQuartoDisponivel(tipoQuarto);
				if (isPeriodoDisponivel) {
					agendaTemp.adicionar(tipoQuarto);
				} else {
					break;
				}
			} else {
				agendaTemp.adicionar(tipoQuarto);
				agendaCopy.add(agendaTemp);
			}
			dataVerificacao = dataVerificacao.plusDays(1);
		}

		if (isPeriodoDisponivel) {
			this.reservas.add(reserva);
			this.agenda = new ArrayList<>(agendaCopy);
		} else {
			throw new HotelariaException("Não foi possível realizar a reserva para o periodo informado.");
		}

	}

	public void editarEndereco(Endereco endereco) {
		if (endereco != null) {
			this.endereco = endereco;
		}
	}

	public void adicionarQuarto(Quarto quarto) {
		if (quarto != null) {
			this.quartos.add(quarto);
		}
	}

	public Quarto getQuartoDisponivelFromTipo(TipoQuarto tipoQuarto) throws HotelariaException {
		return this.getQuartos().stream().filter(
				q -> q.getDisponibilidade().equals(Disponibilidade.DISPONIVEL) && q.getTipoQuarto().equals(tipoQuarto))
				.findFirst().orElseThrow(HotelariaException::new);
	}

	public void novoFuncionario(Funcionario funcionario) {
		if (funcionario != null) {
			this.funcionarios.add(funcionario);
		}
	}

	public List<Quarto> getQuartos() {
		return quartos;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getRegrasHotel() {
		return regrasHotel;
	}

	public void setRegrasHotel(String regrasHotel) {
		this.regrasHotel = regrasHotel;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Hotel hotel = (Hotel) o;
		return cnpj.equals(hotel.cnpj);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj);
	}

}
