package hotelaria;

import br.fesppr.bsi.topicos.hotelaria.exceptions.HotelariaException;
import br.fesppr.bsi.topicos.hotelaria.model.Hospede;
import br.fesppr.bsi.topicos.hotelaria.model.Hotel;
import br.fesppr.bsi.topicos.hotelaria.model.Quarto;
import br.fesppr.bsi.topicos.hotelaria.model.Reserva;
import br.fesppr.bsi.topicos.hotelaria.model.enums.TipoQuarto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Hotel Specs")
public class HotelSpec {

    Hotel hotel;

    static Hospede hospede;
    static Reserva reserva1;
    static Reserva reserva2;
    static Reserva reserva3;
    static Reserva reservaInvalida;

    @BeforeAll
    static void setAll() throws HotelariaException {
        LocalDate nascimento = LocalDate.of(1995, Month.JUNE, 3);
        hospede = new Hospede("Eduardo", "Cruz", nascimento, "09611848927", "41 99999999", "email@email.com");

        reserva1 = new Reserva(hospede, TipoQuarto.CONFORTO_01);
        reserva1.solicitarReserva(LocalDate.of(2021, Month.SEPTEMBER, 20),LocalDate.of(2021, Month.SEPTEMBER, 21));

        reserva2 = new Reserva(hospede, TipoQuarto.CONFORTO_01);
        reserva2.solicitarReserva(LocalDate.of(2021, Month.SEPTEMBER, 26),LocalDate.of(2021, Month.SEPTEMBER, 28));

        reserva3 = new Reserva(hospede, TipoQuarto.CONFORTO_01);
        reserva3.solicitarReserva(LocalDate.of(2021, Month.OCTOBER, 20),LocalDate.of(2021, Month.OCTOBER, 25));

        reservaInvalida = new Reserva(hospede, TipoQuarto.CONFORTO_01);
        reservaInvalida.solicitarReserva(LocalDate.of(2021, Month.SEPTEMBER, 20),LocalDate.of(2021, Month.SEPTEMBER, 21));
    }

    @BeforeEach
    void init() {
        hotel = new Hotel("ABC", "123456");

        hotel.adicionarQuarto(new Quarto(TipoQuarto.CONFORTO_01));
        hotel.adicionarQuarto(new Quarto(TipoQuarto.CONFORTO_01));
        hotel.adicionarQuarto(new Quarto(TipoQuarto.CONFORTO_01));
    }

    @DisplayName("Reservas do hotel deve ser igual a 0.")
    @Test
    void hotelReservasShouldBeZero() {
        assertEquals(0, hotel.getReservas().size(), "Hotel não deve possuir reservas!");
    }

    @DisplayName("Reservas do hotel deve ser igual a 1.")
    @Test
    void hotelReservasShouldBeOne() throws HotelariaException {
        hotel.validarDisponibilidade(reserva1);
        assertEquals(1, hotel.getReservas().size(), "Hotel deve possuir uma reserva!");
    }

    @DisplayName("Reservas do hotel deve ser igual a 2.")
    @Test
    void hotelReservasShouldBeTwo() throws HotelariaException {
        hotel.validarDisponibilidade(reserva1);
        hotel.validarDisponibilidade(reserva2);
        assertEquals(2, hotel.getReservas().size(), "Hotel deve possuir duas reservas!");
    }

    @DisplayName("Reservas do hotel deve ser igual a 3.")
    @Test
    void hotelReservasShouldBeThree() throws HotelariaException {
        hotel.validarDisponibilidade(reserva1);
        hotel.validarDisponibilidade(reserva2);
        hotel.validarDisponibilidade(reserva3);
        assertEquals(3, hotel.getReservas().size(), "Hotel deve possuir três reservas!");
    }

    @DisplayName("Deve lançar uma exceção ao tentar fazer uma reserva em um periodo inválido.")
    @Test
    void shouldThrowExceptionOnInvalidDateRange() throws HotelariaException {
        hotel.validarDisponibilidade(reserva1);
        hotel.validarDisponibilidade(reserva1);
        hotel.validarDisponibilidade(reserva1);
        HotelariaException ex = assertThrows(HotelariaException.class, () -> hotel.validarDisponibilidade(reservaInvalida));
        assertEquals("Não foi possível realizar a reserva para o periodo informado.", ex.getMessage());
    }


}
