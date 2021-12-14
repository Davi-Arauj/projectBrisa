package projeto.brisa.teste.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import projeto.brisa.teste.dto.ContratoDTO;
import projeto.brisa.teste.entity.Contrato;
import projeto.brisa.teste.entity.Ponto;
import projeto.brisa.teste.repositories.ContratoRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ContratoService {
	
	private ContratoRepository contratoRepository;
	
	private PontoService pontoService;
	
	private ModelMapper contratoMapper;
	
	public ContratoDTO create(ContratoDTO contratoDto) {
		Contrato contrato = new Contrato();
		Ponto ponto = pontoService.findId(contratoDto.getPonto_id());
		contrato.setPonto(ponto);
		contratoRepository.save(contrato);
		return toContratoModel(contrato);
	}
	
	
	// Transforma o Contrato em ContratoDTO
		public ContratoDTO toContratoModel(Contrato con) {
			return contratoMapper.map(con, ContratoDTO.class);
		}

	
}
