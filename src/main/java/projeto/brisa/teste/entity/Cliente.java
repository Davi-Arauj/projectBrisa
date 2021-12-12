package projeto.brisa.teste.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import projeto.brisa.teste.enums.ClienteType;

@Data
@Entity
public class Cliente implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private ClienteType tipo;
	
	
	public Cliente(Integer id, String name, ClienteType tipo) {
		super();
		this.id = id;
		this.nome = name;
		this.tipo = (tipo==null) ? null : tipo;
		
	}
	public Cliente() {
		
	}
	
	
}
