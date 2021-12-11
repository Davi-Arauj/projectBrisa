package projeto.brisa.teste.enums;

public enum ClienteType {

	JURIDICO(1, "Juridico"), FISICO(2, "Fisico"), ESPECIAL(3, "Especial");

	private Integer cod;
	private String description;

	private ClienteType(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static ClienteType toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}
		for (ClienteType x : ClienteType.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id invalid " + cod);

	}
}
