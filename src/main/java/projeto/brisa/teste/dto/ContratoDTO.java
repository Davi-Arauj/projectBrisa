package projeto.brisa.teste.dto;

import java.io.Serializable;

import lombok.Data;
import projeto.brisa.teste.entity.Contrato;
import projeto.brisa.teste.enums.ContratoType;

@Data
public class ContratoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
 
	
	private Long id; 
	
	private Long ponto_id;
	
	private ContratoType estadoAtual;

	public ContratoDTO(Contrato obj) {
		this.id = obj.getId();
		this.ponto_id = obj.getPonto().getId();
		this.estadoAtual = obj.getEstadoAtual();
	}

	public ContratoDTO() {
		
	}
	
	
}
