package hotelaria;

import br.fesppr.bsi.topicos.hotelaria.exceptions.HotelariaException;
import br.fesppr.bsi.topicos.hotelaria.exceptions.ReservaException;
import br.fesppr.bsi.topicos.hotelaria.model.Hospede;
import br.fesppr.bsi.topicos.hotelaria.model.Reserva;
import br.fesppr.bsi.topicos.hotelaria.model.enums.TipoQuarto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Reserva Specs")
public class ReservaSpec {

    Reserva reserva;
    Hospede hospede;

    @BeforeEach
    void init() {
        LocalDate nascimento = LocalDate.of(1995, Month.JUNE, 3);
        hospede = new Hospede("Eduardo", "Cruz", nascimento, "09611848927", "41 99999999", "email@email.com");
        try {
            reserva = new Reserva(hospede, TipoQuarto.CONFORTO_01);
        } catch (Exception ignored) {
        }
    }

    @DisplayName("Deve lançar uma exception ao tentar criar uma reserva com um Hospede nulo")
    @Test
    void throwExceptionWhenHospedeIsNull() throws HotelariaException {
        hospede = null;
        HotelariaException ex = assertThrows(HotelariaException.class, () -> new Reserva(hospede, null));
        assertEquals("Hospede não pode ser nulo.", ex.getMessage());
    }

    @DisplayName("Deve lançar uma exception ao tentar passar uma entrada nula.")
    @Test
    void throwExceptionWhenEntradaIsNull() throws ReservaException {
        LocalDate entrada = null, saida = LocalDate.of(2021, Month.JUNE, 3);
        ReservaException ex = assertThrows(ReservaException.class, () -> reserva.solicitarReserva(entrada, saida));
        assertEquals("Informe uma data de reserva válida.", ex.getMessage());
    }

    @DisplayName("Deve lançar uma exception ao tentar passar uma saida nula.")
    @Test
    void throwExceptionWhenSaidaIsNull() throws ReservaException {
        LocalDate entrada = LocalDate.of(2021, Month.JUNE, 3), saida = null;
        ReservaException ex = assertThrows(ReservaException.class, () -> reserva.solicitarReserva(entrada, saida));
        assertEquals("Informe uma data de reserva válida.", ex.getMessage());
    }

    @DisplayName("Deve lançar uma exception ao tentar passar uma data de entrada anterior a data atual.")
    @Test
    void throwExceptionWhenEntradaIsBeforeNow() {
        LocalDate entrada = LocalDate.of(2020, Month.JUNE, 3), saida = LocalDate.of(2020, Month.JUNE, 4);
        ReservaException ex = assertThrows(ReservaException.class, () -> reserva.solicitarReserva(entrada, saida));
        assertEquals("A data de entrada não pode ser anterior a data atual.", ex.getMessage());
    }

    @DisplayName("Deve lançar uma exception ao tentar passar uma data de saida anterior a data de entrada.")
    @Test
    void throwExceptionWhenSaidaIsBeforeEntrada() {
        LocalDate entrada = LocalDate.of(2020, Month.SEPTEMBER, 20), saida = LocalDate.of(2020, Month.SEPTEMBER, 19);
        ReservaException ex = assertThrows(ReservaException.class, () -> reserva.solicitarReserva(entrada, saida));
        assertEquals("A data de saida não pode ser anterior a data de entrada.", ex.getMessage());
    }

    @DisplayName("Deve retornar a data da entrada, saida e precisaBerco como false para uma solicitacao de reserva.")
    @Test
    void shouldReturnEntradaSaidaAndBercoFalse() {
        LocalDate entrada = LocalDate.now().plusDays(1), saida = LocalDate.now().plusDays(3);
        try {
            reserva.solicitarReserva(entrada, saida);
            assertThat(reserva.getEntrada())
                    .isEqualTo(LocalDate.now().plusDays(1));
            assertThat(reserva.getSaida())
                    .isEqualTo(LocalDate.now().plusDays(3));
            assertThat(reserva.isPrecisaBerco())
                    .isEqualTo(false);
        } catch (Exception ignored) {
        }
    }
}
