package projeto.brisa.teste.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import projeto.brisa.teste.dto.EnderecoDTO;
import projeto.brisa.teste.dto.response.EnderecoResponseDTO;
import projeto.brisa.teste.entity.Endereco;
import projeto.brisa.teste.exception.DataDuplicateException;
import projeto.brisa.teste.exception.ObjectNotFoundException;
import projeto.brisa.teste.repositories.EnderecoRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EnderecoService {

	private EnderecoRepository enderecoRepository;

	private ModelMapper enderecoMapper;

	// Criar um Endereco
	public EnderecoDTO create(EnderecoDTO enderecoDto) {
		verifyIfExists(toEndereco(enderecoDto));
		Endereco enderecoSaved = null;
		enderecoSaved = enderecoRepository.save(toEndereco(enderecoDto));
		return toEnderecoModel(enderecoSaved);
	}

	// Busca todos os Enderecos
	public List<EnderecoDTO> findAll() {
		return enderecoRepository.findAll().stream().map(this::toEnderecoModel).collect(Collectors.toList());
	}

	// Atualiza o Endereco
	public EnderecoResponseDTO update(Integer id, EnderecoDTO enderecoDto) {
		
		verifyIfExists(toEndereco(enderecoDto));
		EnderecoDTO endUpdate = findById(id);

		updateData(endUpdate, enderecoDto);
		enderecoRepository.save(toEndereco(endUpdate));
		return createMessageResponse(endUpdate.getId(), "Endereco atualizado ");
	}

	// Verfica se o Endereco existe por o ID
	public EnderecoDTO findById(Integer id) {
		Endereco end = enderecoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Endereco não existe"));
		return toEnderecoModel(end);
	}
	
	// Verfica se o Endereco existe por o ID
		public Endereco findId(Integer id) {
			Endereco end = enderecoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Endereco não existe"));
			return (end);
		}

	// Apagar um Endereco por o ID
	public EnderecoResponseDTO del(Integer id) {
		EnderecoDTO endDto = findById(id);
		enderecoRepository.delete(toEndereco(endDto));
		return createMessageResponse(id, "Endereco apagado com Sucesso! ");
	}

	// Verifica se o Endereco Já existe pelo Logradouro e Numero
	public void verifyIfExists(Endereco enderecoTeste) {
		Endereco enderecoReturn = enderecoRepository.findByLogradouroByNumero(enderecoTeste.getLogradouro(),enderecoTeste.getNumero());
		if (enderecoReturn == null) {
		} else if (enderecoTeste.getLogradouro().equalsIgnoreCase(enderecoReturn.getLogradouro())
				&& enderecoTeste.getNumero().equals(enderecoReturn.getNumero())) {
			throw new DataDuplicateException("O endereco já existe!");
		}

	}

	// Transforma o Endereco em EnderecoDTO
	public EnderecoDTO toEnderecoModel(Endereco end) {
		return enderecoMapper.map(end, EnderecoDTO.class);
	}

	// Transforma o EnderecoDTO em Endereco
	public Endereco toEndereco(EnderecoDTO end) {
		return enderecoMapper.map(end, Endereco.class);
	}

	// Metodo para auxiliar na atualização
	private EnderecoDTO updateData(EnderecoDTO updatedEndereco, EnderecoDTO enderecodto) {
		updatedEndereco.setLogradouro(enderecodto.getLogradouro());
		updatedEndereco.setNumero(enderecodto.getNumero());
		updatedEndereco.setBairro(enderecodto.getBairro());

		return updatedEndereco;
	}

	// Metodo criar menssagem de resposta.
	private EnderecoResponseDTO createMessageResponse(Integer id, String message) {
		return EnderecoResponseDTO.builder().message(message + id).build();
	}

}
