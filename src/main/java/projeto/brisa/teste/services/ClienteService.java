package projeto.brisa.teste.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import projeto.brisa.teste.dto.ClienteDTO;
import projeto.brisa.teste.dto.response.ClienteResponseDTO;
import projeto.brisa.teste.entity.Cliente;
import projeto.brisa.teste.exception.DataDuplicateException;
import projeto.brisa.teste.exception.ObjectNotFoundException;
import projeto.brisa.teste.repositories.ClienteRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteService {

	private ClienteRepository clienteRepository;

	private ModelMapper clienteMapper;

	// Criar um Cliente
	public ClienteDTO create(ClienteDTO clienteDto)  {
		verifyIfExists(toCliente(clienteDto));
		Cliente clienteSaved = null;
		Cliente cli = toCliente(clienteDto);
		clienteSaved = clienteRepository.save(cli);
		
		return toClienteModel(clienteSaved);
	}

	// Busca todos os Clientes
	public List<ClienteDTO> findAll() {
		return clienteRepository.findAll().stream().map(this::toClienteModel).collect(Collectors.toList());
	}

	// Atualiza o Cliente
	public ClienteResponseDTO update(Integer id, ClienteDTO clienteDto) {
		verifyIfExists(toCliente(clienteDto));
		ClienteDTO cliUpdate = findById(id);

		updateData(cliUpdate, clienteDto);
		clienteRepository.save(toCliente(cliUpdate));
		return createMessageResponse(cliUpdate.getId(), "Cliente atualizado ");
	}

	// Verfica se o Cliente existe por o ID
	public ClienteDTO findById(Integer id) {
		Cliente cli = clienteRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Cliente não existe"));
		return toClienteModel(cli);
	}

	// Apagar um Cliente por o ID
	public ClienteResponseDTO del(Integer id) {
		ClienteDTO cliDto = findById(id);
		clienteRepository.delete(toCliente(cliDto));
		return createMessageResponse(id, "Cliente apagado com Sucesso! ");
	}

	// Verifica se o Cliente Já existe pelo Nome
	public void verifyIfExists(Cliente clienteTeste) {
		Cliente clienteReturn = clienteRepository.findByNome(clienteTeste.getNome());
		if (clienteReturn == null) {
		} else if (clienteTeste.getNome().equalsIgnoreCase(clienteReturn.getNome())) {
			throw new DataDuplicateException("O cliente já existe!");
		}

	}

	// Transforma o Cliente em ClienteDTO
	public ClienteDTO toClienteModel(Cliente cli) {
		return clienteMapper.map(cli, ClienteDTO.class);
	}

	// Transforma o ClienteDTO em Cliente
	public Cliente toCliente(ClienteDTO cli) {
		return clienteMapper.map(cli, Cliente.class);
	}

	// Metodo para auxiliar na atualização
	private ClienteDTO updateData(ClienteDTO updatedClient, ClienteDTO clientdto) {
		updatedClient.setNome(clientdto.getNome());
		updatedClient.setTipo(clientdto.getTipo());
		return updatedClient;
	}

	// Metodo criar menssagem de resposta.
	private ClienteResponseDTO createMessageResponse(Integer id, String message) {
		return ClienteResponseDTO.builder().message(message + id).build();
	}

}
