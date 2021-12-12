package projeto.brisa.teste.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import projeto.brisa.teste.dto.EnderecoDTO;
import projeto.brisa.teste.dto.response.EnderecoResponseDTO;
import projeto.brisa.teste.exception.ObjectNotFoundException;
import projeto.brisa.teste.services.EnderecoService;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/enderecos")
public class EnderecoController {

	private EnderecoService enderecoService;

	@GetMapping("/{id}")
	public EnderecoDTO find(@PathVariable Integer id) {
		return enderecoService.findById(id);
	}

	@GetMapping
	public List<EnderecoDTO> findAll() {
		return enderecoService.findAll();

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EnderecoDTO createdEndereco(@RequestBody @Valid EnderecoDTO enderecoDto) {
		return enderecoService.create(enderecoDto);
	}

	@PutMapping("/{id}")
	public EnderecoResponseDTO updateEndereco(@PathVariable Integer id, @RequestBody EnderecoDTO enderecoDto)
			throws ObjectNotFoundException {
		return enderecoService.update(id, enderecoDto);
	}

	@DeleteMapping("/{id}")
	public EnderecoResponseDTO deleteEndereco(@PathVariable Integer id) {
		return enderecoService.del(id);
	}

}
