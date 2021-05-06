package utils;

public enum TipoPessoaEnum {
	FISICA("Física"),
	JURIDICA("Jurídica");
	
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	
	private TipoPessoaEnum(final String descricao) {
		this.descricao = descricao;
	}

}
