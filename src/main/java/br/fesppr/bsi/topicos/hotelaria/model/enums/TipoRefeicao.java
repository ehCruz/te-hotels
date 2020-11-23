package br.fesppr.bsi.topicos.hotelaria.model.enums;

public enum TipoRefeicao {

	CAFE_MANHA(1L, "Caf� da manha"), ALMOCO(2L, "Almo�o"), JANTAR(3L, "Jantar");

	private Long id;
	private String descricao;

	private TipoRefeicao(Long id, String descricao) {
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
