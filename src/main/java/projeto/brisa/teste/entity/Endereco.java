package projeto.brisa.teste.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String logradouro;
	private String bairro;
	private Integer numero;
	public Endereco(Integer id, String logradouro, String bairro, Integer numero) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.numero = numero;
	}
	public Endereco() {
		
	}
	
	
	}
