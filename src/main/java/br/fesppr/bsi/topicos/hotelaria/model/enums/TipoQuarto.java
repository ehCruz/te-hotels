package br.fesppr.bsi.topicos.hotelaria.model.enums;

public enum TipoQuarto {

    CONFORTO_01(1L, "1 cama de casal"),
    CONFORTO_02(2L, "2 camas de solteiro"),
    CONFORTO_03(3L, "1 cama de casal e 1 cama de solteiro");

    private Long id;
    private String descricao;

    TipoQuarto(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
