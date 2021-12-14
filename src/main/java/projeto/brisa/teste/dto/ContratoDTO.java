package projeto.brisa.teste.dto;

import java.io.Serializable;

import lombok.Data;
import projeto.brisa.teste.entity.Contrato;

@Data
public class ContratoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
 
	
	private Integer id; 
	
	private Integer ponto_id;

	public ContratoDTO(Contrato obj) {
		this.id = obj.getId();
		this.ponto_id = obj.getPonto().getId();
	}

	public ContratoDTO() {
		
	}
	
	
}
