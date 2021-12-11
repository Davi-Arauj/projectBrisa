package projeto.brisa.teste.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import projeto.brisa.teste.dto.ClienteDTO;
import projeto.brisa.teste.entity.Cliente;
import projeto.brisa.teste.exception.DataDuplicateException;
import projeto.brisa.teste.exception.ObjectNotFoundException;
import projeto.brisa.teste.repositories.ClienteRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteService {

	private ClienteRepository clienteRepository;

	private ModelMapper clienteMapper;

	public ClienteDTO create(ClienteDTO clienteDto) {
		verifyIfExists(toCliente(clienteDto));
		Cliente clienteSaved = null;
		clienteSaved = clienteRepository.save(toCliente(clienteDto));
		return toClienteModel(clienteSaved);
	}

	public List<ClienteDTO> findAll() {
		return clienteRepository.findAll().stream().map(this::toClienteModel).collect(Collectors.toList());
	}

	public ClienteDTO update(ClienteDTO clienteDto) {
		Cliente cliUpdate = verifyById(clienteDto.getId());
		
		updateData(cliUpdate, clienteDto);
		clienteRepository.save(cliUpdate);
		return toClienteModel(cliUpdate);
	}
	
	public Cliente verifyById(Integer id) {
		return clienteRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cliente não existe"));
	}
	
	public void del(ClienteDTO clienteDto) {
		Cliente cliente = toCliente(clienteDto);
		clienteRepository.deleteById(cliente.getId());
	}

	public void verifyIfExists(Cliente clienteTeste) {

		Cliente clienteReturn = clienteRepository.findByName(clienteTeste.getName());
		if (clienteReturn == null) {
		} else if (clienteReturn.getName().equals(clienteTeste.getName())) {

			throw new DataDuplicateException("O cliente já existe!");
		}

	}

	public ClienteDTO toClienteModel(Cliente cli) {
		return clienteMapper.map(cli, ClienteDTO.class);
	}

	public Cliente toCliente(ClienteDTO cli) {
		return clienteMapper.map(cli, Cliente.class);
	}
	
	// Metodo para auxiliar na atualização
		private Cliente updateData(Cliente updatedClient, ClienteDTO clientdto) {
			updatedClient.setName(clientdto.getName());
			updatedClient.setTypeClient(clientdto.getTypeClient());
			return updatedClient;
		}
}
