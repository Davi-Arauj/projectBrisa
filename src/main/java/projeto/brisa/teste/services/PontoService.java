package projeto.brisa.teste.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import projeto.brisa.teste.dto.PontoDTO;
import projeto.brisa.teste.dto.response.PontoResponseDTO;
import projeto.brisa.teste.entity.Ponto;
import projeto.brisa.teste.exception.DataDuplicateException;
import projeto.brisa.teste.exception.ObjectNotFoundException;
import projeto.brisa.teste.repositories.PontoRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PontoService {

	private PontoRepository pontoRepository;
	
	private ClienteService clienteService;
	
	private EnderecoService enderecoService;

	private ModelMapper pontoMapper;

	public PontoDTO create(PontoDTO ponDTO) {
		
		Ponto pon = new Ponto();
				pon.setCliente(clienteService.findId(ponDTO.getCliente_id()));
				pon.setEndereco( enderecoService.findId(ponDTO.getEndereco_id()));
				pon.setId(ponDTO.getId());
		PontoDTO pontoSaved = new PontoDTO(pon);
	
		//verificar se o ponto já existe
		Ponto pontoTeste = pontoRepository.findByClienteByEndereco
				(pon.getCliente().getNome(), pon.getEndereco().getLogradouro());	
		
		if(pontoTeste != null) {
			
			System.out.println("Depois da busca no banco "+pontoTeste.getCliente().getNome());
			System.out.println("Depois da busca no banco "+pontoTeste.getEndereco().getLogradouro());
			throw new DataDuplicateException("O Ponto já existe!");
		}
		
		pontoRepository.save(toPonto(pontoSaved));
		return (pontoSaved);
		
	}

	public List<Ponto> findAll() {
		return pontoRepository.findAll();
	}

	// Transforma o Ponto em PontoDTO
	public PontoDTO toPontoModel(Ponto pon) {
		return pontoMapper.map(pon, PontoDTO.class);
	}

	// Transforma o PontoDTO em Ponto Apenas se existirem CLiente e Endereço
	public Ponto toPonto(PontoDTO ponDTO) {
				
		Ponto pon = new Ponto();
		pon.setCliente(clienteService.findId(ponDTO.getCliente_id()));
		pon.setEndereco( enderecoService.findId(ponDTO.getEndereco_id()));
		pon.setId(ponDTO.getId());

		return pon;
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
	
	// Verfica se o Ponto existe por o ID
		public Ponto findId(Integer id) {
			Ponto pon = pontoRepository.findById(id)
					.orElseThrow(() -> new ObjectNotFoundException("Ponto não existe"));
			return (pon);
		}
	
	// Metodo criar menssagem de resposta.
		private PontoResponseDTO createMessageResponse(Integer id, String message) {
			return PontoResponseDTO.builder().message(message + id).build();
		}

}
