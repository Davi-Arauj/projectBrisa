package projeto.brisa.teste.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import projeto.brisa.teste.dto.ClienteDTO;
import projeto.brisa.teste.dto.response.ClienteResponseDTO;
import projeto.brisa.teste.exception.ObjectNotFoundException;
import projeto.brisa.teste.services.ClienteService;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/clientes")
@Api(value = "Api Rest Clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

	private ClienteService clienteService;

	//Retorna um Cliente
	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um Cliente")
	public ClienteDTO find(@PathVariable Long id) {
		return clienteService.findById(id);
	}

	//Retorna uma Lista de Clientes
	@GetMapping
	@ApiOperation(value = "Retorna uma Lista de Clientes")
	public List<ClienteDTO> findAll() {
		return clienteService.findAll();

	}
	
	//Salva um Cliente
	@PostMapping
	@ApiOperation(value = "Salva um Cliente")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ClienteDTO> createdCliente(@RequestBody @Valid ClienteDTO clienteDto) {
		return ResponseEntity.ok().body(clienteService.create(clienteDto));
	}

	//Atualiza um Cliente
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza um Cliente")
	public ClienteResponseDTO updateCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDto)
			throws ObjectNotFoundException {
		return clienteService.update(id, clienteDto);
	}

	//Deleta um Cliente
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta um Cliente")
	public ClienteResponseDTO deleteCliente(@PathVariable Long id) {
		return clienteService.del(id);
	}

}
