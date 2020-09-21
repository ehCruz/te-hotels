package br.fesppr.bsi.topicos.hotelaria.model;

import br.fesppr.bsi.topicos.hotelaria.exceptions.HotelariaException;
import br.fesppr.bsi.topicos.hotelaria.exceptions.ReservaException;
import br.fesppr.bsi.topicos.hotelaria.model.enums.TipoQuarto;
import br.fesppr.bsi.topicos.hotelaria.model.utils.pagamento.CartaoCredito;
import br.fesppr.bsi.topicos.hotelaria.model.utils.pagamento.FormaPagamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reserva {

    private LocalDate entrada;
    private LocalDate saida;
    private boolean precisaBerco;
    private BigDecimal valorReserva;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;
    private boolean isCancelada;
    private TipoQuarto tipoQuarto;
    private Hospede hospede;
    private Estadia estadia;
    private Hotel hotel;
    private List<Pagamento> pagamentos = new ArrayList<>();

    public Reserva(Hospede hospede, TipoQuarto tipoQuarto) throws HotelariaException {
        if (hospede != null) {
            this.hospede = hospede;
            this.tipoQuarto = tipoQuarto;
        }
        throw new HotelariaException("Hospede não pode ser nulo.");
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
        }
        throw new ReservaException("Informe uma data de reserva válida.");
    }

    public void solicitarBerco() {
        this.precisaBerco = true;
    }

    public void pagar(FormaPagamento formaPagamento) {
        // TODO fazer com que pagamento mínimo seja de 30% do valor da reserva
        Pagamento pagamento = new Pagamento(formaPagamento);
        pagamento.pagar(valorReserva);
        this.pagamentos.add(pagamento);
    }

    private void cancelarReserva() throws ReservaException {
        if(this.estadia == null) {
            this.isCancelada = true;
            // TODO - devolver pagamento
        }
        throw new ReservaException("Não é possível cancelar uma reserva após o checkin.");
    }

    private void realizarCheckIn() {
        this.horaEntrada = LocalDateTime.now();
        this.estadia = new Estadia(this);
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

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraSaida(LocalDateTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public boolean isCancelada() {
        return isCancelada;
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public Hospede getHospede() {
        return hospede;
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

}
