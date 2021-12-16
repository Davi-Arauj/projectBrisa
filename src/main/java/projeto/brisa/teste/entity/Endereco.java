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

@Data
@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String logradouro;
	private String bairro;
	private Integer numero;

	private Date dataCriacao;

	@JsonIgnore
	@OneToMany(mappedBy = "endereco")
	private List<Ponto> pontos = new ArrayList<>();

	public Endereco(Integer id, String logradouro, String bairro, Integer numero) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.numero = numero;
		setDataCriacao(new Date());

	}

	public Endereco() {
		setDataCriacao(new Date());

	}

}
