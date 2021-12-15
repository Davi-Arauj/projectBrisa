package projeto.brisa.teste.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import projeto.brisa.teste.enums.ContratoType;

@Data
@Entity
public class Contrato implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	private Ponto ponto;
	
	private ContratoType estadoAtual;

	public Contrato(Integer id, Ponto ponto) {
		super();
		this.id = id;
		this.ponto = ponto;
		this.estadoAtual = ContratoType.EM_VIGOR;
	}

	public Contrato() {
		this.estadoAtual = ContratoType.EM_VIGOR;
	}
	
	public ContratoType VigorDesativado() {
		return this.estadoAtual = ContratoType.DESATIVADO_TEMPORARIO;
	}
	
	public ContratoType DesativadoAtivo() {
		return this.estadoAtual = ContratoType.EM_VIGOR;

	}
	
	public ContratoType DesativadoCancelado() {
		return this.estadoAtual = ContratoType.CANCELADO;

	}
	
}
