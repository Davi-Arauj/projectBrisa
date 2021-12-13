package projeto.brisa.teste.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PontoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer cliente_id;
	
	private Integer endereco_id;

	public PontoDTO() {
	}

	public PontoDTO(Integer cli,Integer endereco) {

		this.cliente_id = cli;
		this.endereco_id = endereco;
	}

}
