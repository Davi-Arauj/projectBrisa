package projeto.brisa.teste.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import projeto.brisa.teste.dto.EnderecoDTO;
import projeto.brisa.teste.dto.response.EnderecoResponseDTO;
import projeto.brisa.teste.exception.ObjectNotFoundException;
import projeto.brisa.teste.services.EnderecoService;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/enderecos")
@Api(value="Rest API Endereço")
@CrossOrigin(origins = "*")
public class EnderecoController {

	private EnderecoService enderecoService;

	@GetMapping("/{id}")
	@ApiOperation(value="Retorna um Endereço")
	public EnderecoDTO find(@PathVariable Integer id) {
		return enderecoService.findById(id);
	}

	@GetMapping
	@ApiOperation(value="Retorna uma Lista de Endereços")
	public List<EnderecoDTO> findAll() {
		return enderecoService.findAll();

	}

	@PostMapping
	@ApiOperation(value="Salva um Endereço")
	@ResponseStatus(HttpStatus.CREATED)
	public EnderecoDTO createdEndereco(@RequestBody @Valid EnderecoDTO enderecoDto) {
		return enderecoService.create(enderecoDto);
	}

	@PutMapping("/{id}")
	@ApiOperation(value="Atualiza um Endereço")
	public EnderecoResponseDTO updateEndereco(@PathVariable Integer id, @RequestBody EnderecoDTO enderecoDto)
			throws ObjectNotFoundException {
		return enderecoService.update(id, enderecoDto);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value="Deleta um Endereço")
	public EnderecoResponseDTO deleteEndereco(@PathVariable Integer id) {
		return enderecoService.del(id);
	}

}
