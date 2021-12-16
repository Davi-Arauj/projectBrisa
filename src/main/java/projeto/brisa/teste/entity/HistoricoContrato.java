package projeto.brisa.teste.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import projeto.brisa.teste.enums.ContratoType;

@Entity
@Data
public class HistoricoContrato implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	private Date dataEvento ;
	private ContratoType estadoAntigo;
	private ContratoType estadoNovo;
	
	@JsonIgnore
	@OneToOne
	private Contrato contrato;
	
	public HistoricoContrato(Integer id, Date dataEvento, ContratoType estadoAntigo, ContratoType estadoNovo,
			Contrato contrato) {
		super();
		this.id = id;
		this.dataEvento = dataEvento;
		this.estadoAntigo = estadoAntigo;
		this.estadoNovo = estadoNovo;
		this.contrato = contrato;
	}
	public HistoricoContrato() {
		setDataEvento(new Date());

	}

	

}
