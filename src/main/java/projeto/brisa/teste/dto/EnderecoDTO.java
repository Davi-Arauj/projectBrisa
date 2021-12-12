package projeto.brisa.teste.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import projeto.brisa.teste.entity.Endereco;

@Data
public class EnderecoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotBlank
	private String logradouro;
	@NotBlank
	private String bairro;
	@NotNull
	private Integer numero;
	
	public EnderecoDTO(Endereco obj) {
		
		this.id = obj.getId();
		this.logradouro = obj.getLogradouro();
		this.bairro = obj.getBairro();
		this.numero = obj.getNumero();
	}
	public EnderecoDTO() {
		
	}
}
