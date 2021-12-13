package projeto.brisa.teste.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import projeto.brisa.teste.dto.ClienteDTO;
import projeto.brisa.teste.dto.PontoDTO;
import projeto.brisa.teste.dto.response.ClienteResponseDTO;
import projeto.brisa.teste.dto.response.PontoResponseDTO;
import projeto.brisa.teste.entity.Cliente;
import projeto.brisa.teste.entity.Endereco;
import projeto.brisa.teste.entity.Ponto;
import projeto.brisa.teste.exception.ObjectNotFoundException;
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

		Ponto pontoSaved = new Ponto(cli, end);

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

	public PontoResponseDTO del(Integer id) {
		PontoDTO pontoDto = findById(id);
		pontoRepository.delete(toPonto(pontoDto));
		return createMessageResponse(id, "Ponto apagado com Sucesso! ");
	}

	// Verfica se o Ponto existe por o ID
	public PontoDTO findById(Integer id) {
		Ponto pon = pontoRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Ponto não existe"));
		return toPontoModel(pon);
	}
	
	// Metodo criar menssagem de resposta.
		private PontoResponseDTO createMessageResponse(Integer id, String message) {
			return PontoResponseDTO.builder().message(message + id).build();
		}

}
