package br.fesppr.bsi.topicos.hotelaria.model;

import br.fesppr.bsi.topicos.hotelaria.exceptions.HotelariaException;
import br.fesppr.bsi.topicos.hotelaria.exceptions.ReservaException;
import br.fesppr.bsi.topicos.hotelaria.model.enums.TipoQuarto;
import br.fesppr.bsi.topicos.hotelaria.model.utils.pagamento.FormaPagamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {

    private LocalDate entrada;
    private LocalDate saida;
    private boolean precisaBerco;
    private BigDecimal valorReserva;
    private boolean isCancelada;
    private TipoQuarto tipoQuarto;
    private Hospede hospede;
    private Estadia estadia;
    private Hotel hotel;
    private List<Pagamento> pagamentos = new ArrayList<>();

    public Reserva(Hospede hospede, TipoQuarto tipoQuarto, Hotel hotel) throws HotelariaException {
        if (hospede == null) {
            throw new HotelariaException("Hospede não pode ser nulo.");
        }
        this.hospede = hospede;
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

    public void pagar(FormaPagamento formaPagamento) {
        // TODO fazer com que pagamento mínimo seja de 30% do valor da reserva
        Pagamento pagamento = new Pagamento(formaPagamento, this);
        pagamento.pagar(this.valorReserva);
        this.pagamentos.add(pagamento);
    }

    public void cancelarReserva() throws ReservaException {
        if (this.estadia == null) {
            this.isCancelada = true;
            // TODO - devolver pagamento
        }
        throw new ReservaException("Não é possível cancelar uma reserva após o checkin.");
    }

    public void realizarCheckIn() {
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
