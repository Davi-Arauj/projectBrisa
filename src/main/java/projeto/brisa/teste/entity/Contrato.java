package projeto.brisa.teste.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Contrato implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	private Ponto ponto;
	
	private String estadoAtual;

	public Contrato(Integer id, Ponto ponto) {
		super();
		this.id = id;
		this.ponto = ponto;
		this.estadoAtual = "Em Vigor";
	}

	public Contrato() {
		this.estadoAtual = "Em Vigor";
	}

}
