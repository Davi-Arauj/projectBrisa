package projeto.brisa.teste.dto;

import java.io.Serializable;

import lombok.Data;
import projeto.brisa.teste.entity.Ponto;

@Data
public class PontoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
 
	
	private Integer id; 

	private Integer cliente_id; 
	
	private Integer endereco_id; 
 
	public PontoDTO() { 
	} 

	public PontoDTO(Ponto obj) { 
		this.id = obj.getId(); 
		this.cliente_id = obj.getCliente().getId();
		this.endereco_id = obj.getEndereco().getId();
	}

}
