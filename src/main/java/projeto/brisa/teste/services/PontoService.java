package projeto.brisa.teste.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import projeto.brisa.teste.dto.PontoDTO;
import projeto.brisa.teste.entity.Cliente;
import projeto.brisa.teste.entity.Endereco;
import projeto.brisa.teste.entity.Ponto;
import projeto.brisa.teste.repositories.PontoRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PontoService {
	
	private PontoRepository pontoRepository;
	
	private ModelMapper pontoMapper;

	public PontoDTO create(PontoDTO pontoDTO) {
		Cliente cli = new Cliente();
		Endereco end = new Endereco();
		cli.setId(pontoDTO.getCliente_id());
		end.setId(pontoDTO.getEndereco_id());
				
		Ponto pontoSaved = new Ponto(cli,end);
			
		pontoRepository.save(pontoSaved);
		return toPontoModel(pontoSaved);	
	}
	
	public List<Ponto> findAll() {
		return pontoRepository.findAll();
	}

	

	// Transforma o Ponto em PontoDTO
	public PontoDTO toPontoModel(Ponto pon) {
		return pontoMapper.map(pon, PontoDTO.class);
	}

	// Transforma o PontoDTO em Ponto
	public Ponto toPonto(PontoDTO pon) {
		return pontoMapper.map(pon, Ponto.class);
	}


	
	

}
