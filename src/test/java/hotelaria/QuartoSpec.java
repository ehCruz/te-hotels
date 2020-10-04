package hotelaria;

import br.fesppr.bsi.topicos.hotelaria.model.Hotel;
import br.fesppr.bsi.topicos.hotelaria.model.Quarto;
import br.fesppr.bsi.topicos.hotelaria.model.enums.Disponibilidade;
import br.fesppr.bsi.topicos.hotelaria.model.enums.TipoQuarto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Quarto Specs")
public class QuartoSpec {

    Quarto quarto;
    Hotel hotel;

    @BeforeEach
    void init() {
        hotel = new Hotel("HOTEL TESTE", "000000000");
        quarto = new Quarto(TipoQuarto.CONFORTO_01, hotel);
    }

    @DisplayName("Quarto deve estar Disponivel na criação")
    @Test
    void quartoMustBeDisponivelWhenCreated() {
        assertEquals(Disponibilidade.DISPONIVEL, quarto.getDisponibilidade(), "Quarto deve estar Disponivel.");
    }

    @DisplayName("Berço não pode estar disponivel no momento da criação do Quarto")
    @Test
    void hasBercoMustBeFalseWhenCreated() {
        assertEquals(false, quarto.getHasBerco(), "Berço não Disponivel após criação.");
    }

    @DisplayName("Berço deve estar disponivel apos adiciona-lo.")
    @Test
    void hasBercoMustBeTrueWhenAdicionarBerco() {
        quarto.adicionarBerco();
        assertEquals(true, quarto.getHasBerco(), "Berço deve estar Disponivel após adicionar.");
    }

    @DisplayName("Mudanças na disponibilidade do quarto")
    @Nested
    class QuartoStateChange {
        @DisplayName("Disponibilidade deve ser igual a OCUPADO apos ocupar")
        @Test
        void quartoMustBeOcupadoWhenOcupar() {
            quarto.ocupar();
            assertThat(quarto.getDisponibilidade())
                    .isEqualTo(Disponibilidade.OCUPADO);
        }

        @DisplayName("Disponibilidade deve ser igual a INDISPONIVEL apos indisponibilizar")
        @Test
        void quartoMustBeIndisponivelWhenIndisponibilizar() {
            quarto.indisponibilizar();
            assertThat(quarto.getDisponibilidade())
                    .isEqualTo(Disponibilidade.INDISPONIVEL);
        }

        @DisplayName("Disponibilidade deve ser igual a INDISPONIVEL apos ocupar e checkout")
        @Test
        void quartoMustBeIndisponivelWhenOcuparAndCheckOut() {
            quarto.ocupar();
            assertThat(quarto.getDisponibilidade())
                    .isEqualTo(Disponibilidade.OCUPADO);

            quarto.chekOut();
            assertThat(quarto.getDisponibilidade())
                    .isEqualTo(Disponibilidade.INDISPONIVEL);
        }

        @DisplayName("Disponibilidade deve ser igual a INDISPONIVEL e hasBerco igual a false apos ocupar e checkout")
        @Test
        void quartoMustBeIndisponivelWhenOcuparAndCheckOut_hasBercoIsFalse() {
            quarto.adicionarBerco();
            assertThat(quarto.getHasBerco())
                    .isEqualTo(true);

            quarto.ocupar();
            assertThat(quarto.getDisponibilidade())
                    .isEqualTo(Disponibilidade.OCUPADO);

            quarto.chekOut();
            assertThat(quarto.getDisponibilidade())
                    .isEqualTo(Disponibilidade.INDISPONIVEL);
            assertThat(quarto.getHasBerco())
                    .isEqualTo(false);
        }

        @DisplayName("Disponibilidade deve ser igual a FECHADO apos ocupar, checkout e fechar")
        @Test
        void quartoMustBeIndisponivelWhenOcuparAndCheckOutAndFechar() {
            quarto.ocupar();
            assertThat(quarto.getDisponibilidade())
                    .isEqualTo(Disponibilidade.OCUPADO);

            quarto.chekOut();
            assertThat(quarto.getDisponibilidade())
                    .isEqualTo(Disponibilidade.INDISPONIVEL);

            quarto.fechar();
            assertThat(quarto.getDisponibilidade())
                    .isEqualTo(Disponibilidade.FECHADO);
        }

        @DisplayName("Disponibilidade deve ser igual a FECHADO apos indisponibilizar e fechar")
        @Test
        void quartoMustBeIndisponivelWhenIndisponibilizarAndFechar() {
            quarto.indisponibilizar();
            assertThat(quarto.getDisponibilidade())
                    .isEqualTo(Disponibilidade.INDISPONIVEL);

            quarto.fechar();
            assertThat(quarto.getDisponibilidade())
                    .isEqualTo(Disponibilidade.FECHADO);
        }

        @DisplayName("Disponibilidade deve ser igual a DISPONIVEL apos ocupar, checkout, fechar e liberar")
        @Test
        void quartoMustBeIndisponivelWhenOcuparAndCheckOutAndFecharAndLiberar() {
            quarto.ocupar();
            assertThat(quarto.getDisponibilidade())
                    .isEqualTo(Disponibilidade.OCUPADO);

            quarto.chekOut();
            assertThat(quarto.getDisponibilidade())
                    .isEqualTo(Disponibilidade.INDISPONIVEL);

            quarto.fechar();
            assertThat(quarto.getDisponibilidade())
                    .isEqualTo(Disponibilidade.FECHADO);

            quarto.liberar();
            assertThat(quarto.getDisponibilidade())
                    .isEqualTo(Disponibilidade.DISPONIVEL);
        }

        @DisplayName("Disponibilidade deve ser igual a DISPONIVEL apos indisponibilizar, fechar e liberar")
        @Test
        void quartoMustBeIndisponivelWhenIndisponibilizarAndFecharAndLiberar() {
            quarto.indisponibilizar();
            assertThat(quarto.getDisponibilidade())
                    .isEqualTo(Disponibilidade.INDISPONIVEL);

            quarto.fechar();
            assertThat(quarto.getDisponibilidade())
                    .isEqualTo(Disponibilidade.FECHADO);

            quarto.liberar();
            assertThat(quarto.getDisponibilidade())
                    .isEqualTo(Disponibilidade.DISPONIVEL);
        }
    }

}
