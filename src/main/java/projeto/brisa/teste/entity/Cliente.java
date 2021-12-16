package projeto.brisa.teste.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	private Date dataCriacao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Ponto> pontos = new ArrayList<>();
	
	public Cliente(Integer id, String name, ClienteType tipo) {
		super();
		this.id = id;
		this.nome = name;
		this.tipo = (tipo==null) ? null : tipo;
		setDataCriacao(new Date());
	}
	public Cliente() {
		setDataCriacao(new Date());

	}
	
	
}
