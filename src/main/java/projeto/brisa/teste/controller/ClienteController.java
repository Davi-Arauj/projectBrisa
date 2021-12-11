package projeto.brisa.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import projeto.brisa.teste.dto.ClienteDTO;
import projeto.brisa.teste.services.ClienteService;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/clientes")
public class ClienteController {

	private ClienteService clienteService;

	@GetMapping
	public List<ClienteDTO> findAll(){
		return clienteService.findAll();
		  
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteDTO createdCliente(@RequestBody ClienteDTO clienteDto) {
		return clienteService.create(clienteDto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Integer id,@RequestBody ClienteDTO clienteDto) {
		clienteDto = clienteService.update(clienteDto);
		return ResponseEntity.ok().body(clienteDto);
	}
	

}
