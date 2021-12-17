package projeto.brisa.teste.services;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import projeto.brisa.teste.dto.ContratoDTO;
import projeto.brisa.teste.dto.response.ContratoResponseDTO;
import projeto.brisa.teste.entity.Contrato;
import projeto.brisa.teste.entity.HistoricoContrato;
import projeto.brisa.teste.entity.Ponto;
import projeto.brisa.teste.enums.ContratoType;
import projeto.brisa.teste.exception.DataDuplicateException;
import projeto.brisa.teste.exception.ObjectNotFoundException;
import projeto.brisa.teste.repositories.ContratoRepository;
import projeto.brisa.teste.repositories.HistoricoRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ContratoService {

	private ContratoRepository contratoRepository;

	private HistoricoRepository hcRepository;

	private PontoService pontoService;

//	private HistoricoService hcService;

	private ModelMapper contratoMapper;

	// Criar um contrato
	public ContratoDTO create(ContratoDTO contratoDto) {
		// verificar se o ponto existe se sim adiciona no contrato
		Ponto ponto = pontoService.findId(contratoDto.getPonto_id());
		Contrato contrato = new Contrato();
		contrato.setPonto(ponto);

		Contrato contratoTeste = contratoRepository.findByContratoByPonto(ponto.getId());
		// System.out.println(contratoTeste);
		if (contratoTeste != null) {
			throw new DataDuplicateException("O Contrato já existe!");
		}
		contratoRepository.save(contrato);
		HistoricoContrato hc = new HistoricoContrato();
		hc.setDataEvento(new Date());
		hc.setEstadoAntigo(ContratoType.EM_VIGOR);
		hc.setEstadoNovo(ContratoType.EM_VIGOR);
		hc.setContrato(contrato);
		hcRepository.save(hc);

		return toContratoDTO(contrato);
	}

	// Busca todos os Contrato
	public List<Contrato> findAll() {
		return contratoRepository.findAll();
	}

	// Verfica se o Contrato existe por o ID e retorna um Contrato
	public Contrato findId(Long id) {
		Contrato con = contratoRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("O Contrato não existe"));
		return (con);
	}

	// Apaga o contrato do banco pelo ID
	public ContratoResponseDTO del(Long id) {
		ContratoDTO contratoDto = toContratoDTO(findId(id));
		contratoRepository.delete(toContrato(contratoDto));
		return createMessageResponse(id, "O Contrato apagado com Sucesso! ");
	}

	// Metodo criar menssagem de resposta.
	private ContratoResponseDTO createMessageResponse(Long id, String message) {
		return ContratoResponseDTO.builder().message(message + id).build();
	}

	// Transforma o Contrato em ContratoDTO
	public ContratoDTO toContratoDTO(Contrato con) {
		Ponto pon = pontoService.findId(con.getPonto().getId());
		ContratoDTO contratoDto = new ContratoDTO();
		contratoDto.setId(con.getId());
		contratoDto.setPonto_id(pon.getId());
		return contratoDto;
	}

	// Transforma o ContratoDTO em Contrato
	public Contrato toContrato(ContratoDTO contratoDTO) {
		return contratoMapper.map(contratoDTO, Contrato.class);
	}

	// Atualiza o estado do contrato no Id está o contrato a ser mudado, e no
	// contratoDTO está o novo valor
	public ContratoResponseDTO updateContrato(Long idContrato, ContratoDTO contDTO) {
		Contrato cont = findId(idContrato);

		// EM_VIGOR PARA DESATIVADO_TEMPORARIO
		if (cont.getEstadoAtual().getCod() == 1 && contDTO.getEstadoAtual().getCod() == 2) {
			cont.setEstadoAtual(contDTO.getEstadoAtual());
			contratoRepository.save(cont);
			HistoricoContrato hc = new HistoricoContrato();
			hc.setDataEvento(new Date());
			hc.setEstadoAntigo(ContratoType.EM_VIGOR);
			hc.setEstadoNovo(ContratoType.DESATIVADO_TEMPORARIO);
			hc.setContrato(cont);
			hcRepository.save(hc);
			return createMessageResponse(cont.getId(), "O estado do contrato foi atualizado com sucesso!");

			// EM_VIGOR PARA CANCELADO
		} else if (cont.getEstadoAtual().getCod() == 1 && contDTO.getEstadoAtual().getCod() == 3) {
			return createMessageResponse(cont.getId(), "O estado do contrato não pode ser atualizado!");
			// DESATIVADO_TEMPORARIO PARA CANCELADO
		} else if (cont.getEstadoAtual().getCod() == 2 && contDTO.getEstadoAtual().getCod() == 3) {
			cont.setEstadoAtual(contDTO.getEstadoAtual());
			contratoRepository.save(cont);
			HistoricoContrato hc = new HistoricoContrato();
			hc.setDataEvento(new Date());
			hc.setEstadoAntigo(ContratoType.DESATIVADO_TEMPORARIO);
			hc.setEstadoNovo(ContratoType.CANCELADO);
			hc.setContrato(cont);
			hcRepository.save(hc);
			return createMessageResponse(cont.getId(), "O estado do contrato foi atualizado com sucesso!");

			// DESATIVADO_TEMPORARIO PARA EM_VIGOR
		} else if (cont.getEstadoAtual().getCod() == 2 && contDTO.getEstadoAtual().getCod() == 1) {
			cont.setEstadoAtual(contDTO.getEstadoAtual());
			contratoRepository.save(cont);
			HistoricoContrato hc = new HistoricoContrato();
			hc.setDataEvento(new Date());
			hc.setEstadoAntigo(ContratoType.DESATIVADO_TEMPORARIO);
			hc.setEstadoNovo(ContratoType.EM_VIGOR);
			hc.setContrato(cont);
			hcRepository.save(hc);
			return createMessageResponse(cont.getId(), "O estado do contrato foi atualizado com sucesso!");

			// CANCELADO PARA EM_VIGOR
		} else if (cont.getEstadoAtual().getCod() == 3 && contDTO.getEstadoAtual().getCod() == 1) {
			return createMessageResponse(cont.getId(), "O estado do contrato não pode ser atualizado!");
			// CANCELADO PARA DESATIVADO_TEMPORARIO
		} else if (cont.getEstadoAtual().getCod() == 3 && contDTO.getEstadoAtual().getCod() == 2) {
			return createMessageResponse(cont.getId(), "O estado do contrato não pode ser atualizado!");
		}

		return createMessageResponse(cont.getId(), "verifique e tente novamente");

	}

}
