package projeto.brisa.teste.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import projeto.brisa.teste.enums.ClienteType;

@Data
@Entity
public class Cliente implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String name;
	
	private ClienteType typeClient;
	
	
	public Cliente(Integer id, String name, ClienteType typeClient) {
		super();
		this.id = id;
		this.name = name;
		this.typeClient = (typeClient==null) ? null : typeClient;
		
	}
	public Cliente() {
		
	}
	
	
}
