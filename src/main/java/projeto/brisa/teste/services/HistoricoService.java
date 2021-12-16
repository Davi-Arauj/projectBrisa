package projeto.brisa.teste.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import projeto.brisa.teste.entity.HistoricoContrato;
import projeto.brisa.teste.exception.ObjectNotFoundException;
import projeto.brisa.teste.repositories.HistoricoRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HistoricoService {

	private HistoricoRepository hcRepository;
	//Busca o historico de um contrato
	public HistoricoContrato findId(Integer idContrato) {
		HistoricoContrato hc = hcRepository.findById(idContrato).orElseThrow(() -> new ObjectNotFoundException("Contrato sem historico"));
		return hc;
	}
	
	//Criar um historico
	
	public HistoricoContrato create(HistoricoContrato hc) {
		hcRepository.save(hc);
		return hc;
	}
}
