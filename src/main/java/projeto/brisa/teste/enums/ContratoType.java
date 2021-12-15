package projeto.brisa.teste.enums;

public enum ContratoType {

	EM_VIGOR(1, "Em vigor"), DESATIVADO_TEMPORARIO(2, "Desativado Temporario"), CANCELADO(3, "Cancelado");

	private Integer cod;
	private String description;

	private ContratoType(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static ContratoType toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}
		for (ContratoType x : ContratoType.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id invalid " + cod);

	}
}
