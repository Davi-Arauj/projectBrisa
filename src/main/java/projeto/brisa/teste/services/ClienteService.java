package projeto.brisa.teste.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import projeto.brisa.teste.dto.ClienteDTO;
import projeto.brisa.teste.entity.Cliente;
import projeto.brisa.teste.exception.DataIntegrityException;
import projeto.brisa.teste.mapper.ClienteMapper;
import projeto.brisa.teste.repositories.ClienteRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteService {
	
	private ClienteRepository clienteRepository;
	
	private final ClienteMapper clienteMapper = ClienteMapper.INSTANCE;
	
	public ClienteDTO create(ClienteDTO clienteDto) {
		Cliente cliente = clienteMapper.toModel(clienteDto);
		Cliente clienteSaved = null;
		try {		
			 clienteSaved  = clienteRepository.save(cliente);
		} catch (DataIntegrityException e) {
			e.getMessage();																																																																																																																																																																																																																																																																																																									
		}
		return clienteMapper.toDTO(clienteSaved);
	}

	

	public List<ClienteDTO> findAll() {
		return clienteRepository.findAll()
				.stream()
				.map(clienteMapper :: toDTO)
				.collect(Collectors.toList());
	}
	
	
	public void del(ClienteDTO clienteDto) {
		Cliente cliente = clienteMapper.toModel(clienteDto);
		clienteRepository.deleteById(cliente.getId());
	}
	public void verifyIfExists(Cliente clienteTeste) {
		 Cliente clienteReturn =  clienteRepository.findByName(clienteTeste);
		 	if(clienteReturn.equals(null)){
		 		//não faço nada
		 	}else {
		 		new DataIntegrityException("O cliente já existe!");
		 	}
	}
}
