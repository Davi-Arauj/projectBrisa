package projeto.brisa.teste.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Ponto implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	
	public Ponto(Cliente cli, Endereco end) {
	
		cliente = cli;
		endereco = end;
		
	}
	public Ponto() {
		
	}
	
	public void setIdCliente(Integer id_cliente) {
		cliente.setId(id_cliente);
	}
	public void setIdEndereco(Integer id_endereco) {
		endereco.setId(id_endereco);
	}
	
	

}
