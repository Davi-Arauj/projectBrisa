package projeto.brisa.teste.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import projeto.brisa.teste.entity.Cliente;
import projeto.brisa.teste.enums.ClienteType;

@Data
public class ClienteDTO implements Serializable{


	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotBlank
	private String nome;
	
	@NotNull
	private ClienteType tipo;
	
	public ClienteDTO() {
		
	}
	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		tipo = obj.getTipo();
	}
}
