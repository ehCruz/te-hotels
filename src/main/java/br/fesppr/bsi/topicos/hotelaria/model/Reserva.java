package br.fesppr.bsi.topicos.hotelaria.model;

import br.fesppr.bsi.topicos.hotelaria.exceptions.HotelariaException;
import br.fesppr.bsi.topicos.hotelaria.exceptions.ReservaException;
import br.fesppr.bsi.topicos.hotelaria.model.enums.TipoQuarto;

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
        if (hospede == null) {
            throw new HotelariaException("Hospede não pode ser nulo.");
        }
        this.hospede = hospede;
        this.tipoQuarto = tipoQuarto;
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

    private void cancelarReserva() {
        this.isCancelada = true;
        // TODO - devolver pagamento
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

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public Hotel getHotel() {
        return hotel;
    }
}
