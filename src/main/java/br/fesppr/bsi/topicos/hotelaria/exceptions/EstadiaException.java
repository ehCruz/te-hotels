package br.fesppr.bsi.topicos.hotelaria.exceptions;

public class EstadiaException extends Exception {

    public EstadiaException() {
        this("Error na Estadia");
    }

    public EstadiaException(String message) {
        super(message);
    }

    public EstadiaException(String message, Throwable cause) {
        super(message, cause);
    }
}
