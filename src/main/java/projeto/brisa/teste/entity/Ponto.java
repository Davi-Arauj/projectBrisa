package projeto.brisa.teste.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
public class Ponto implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	private Date dataCriacao;
	
	public Ponto(Long idPonto,Cliente cli, Endereco end) {
	
		id = idPonto;
		cliente = cli;
		endereco = end;
		setDataCriacao(new Date());

	}
	public Ponto() {
		setDataCriacao(new Date());
	}
	
	public void setIdCliente(Long id_cliente) {
		cliente.setId(id_cliente);
	}
	public void setIdEndereco(Integer id_endereco) {
		endereco.setId(id_endereco);
	}
	
	

}
