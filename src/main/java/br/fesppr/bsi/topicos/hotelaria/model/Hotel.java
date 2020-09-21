package br.fesppr.bsi.topicos.hotelaria.model;

import br.fesppr.bsi.topicos.hotelaria.exceptions.HotelariaException;
import br.fesppr.bsi.topicos.hotelaria.model.enums.TipoQuarto;

import java.time.LocalDate;
import java.util.*;

public class Hotel {

    private String nomeFantasia;
    private String cnpj;
    private String regrasHotel;
    private Endereco endereco;
    private List<Agenda> agenda = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
    private List<Contato> contatos = new ArrayList<>();
    private List<Quarto> quartos = new ArrayList<>();

    public Hotel(String nomeFantasia, String cnpj) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
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

    public void adicionarNovoContato(Contato contato) {
        if (contato != null) {
            this.contatos.add(contato);
        }
    }

    public void adicionarQuarto(Quarto quarto) {
        if (quarto != null) {
            this.quartos.add(quarto);
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

    public Endereco getEndereco() {
        return endereco;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return cnpj.equals(hotel.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj);
    }

}
