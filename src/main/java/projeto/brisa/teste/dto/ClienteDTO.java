package projeto.brisa.teste.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import projeto.brisa.teste.entity.Cliente;
import projeto.brisa.teste.enums.ClienteType;

@Data
public class ClienteDTO implements Serializable{


	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotNull
	@Size(min = 2, max = 200)
	private String name;
	
	private ClienteType typeClient;
	
	public ClienteDTO() {
		
	}
	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		name = obj.getName();
		typeClient = obj.getTypeClient();
	}
}
