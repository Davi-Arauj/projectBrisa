package projeto.brisa.teste.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import projeto.brisa.teste.dto.ClienteDTO;
import projeto.brisa.teste.entity.Cliente;
import projeto.brisa.teste.mapper.ClienteMapper;
import projeto.brisa.teste.repositories.ClienteRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteService {
	
	private ClienteRepository clienteRepository;
	
	private final ClienteMapper clienteMapper = ClienteMapper.INSTANCE;
	
	public ClienteDTO create(ClienteDTO clienteDto) {
		verifyIfExists(clienteDto.getId());
		Cliente cliente = clienteMapper.toModel(clienteDto);
		Cliente clienteSaved  = clienteRepository.save(cliente);
		return clienteMapper.toDTO(clienteSaved);
	}

	public Optional<Cliente> verifyIfExists(Integer id) {
		return clienteRepository.findById(id);
	}

	public List<ClienteDTO> findAll() {
		return clienteRepository.findAll()
				.stream()
				.map(clienteMapper :: toDTO)
				.collect(Collectors.toList());
	}
}
