package projeto.brisa.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import projeto.brisa.teste.dto.PontoDTO;
import projeto.brisa.teste.dto.response.PontoResponseDTO;
import projeto.brisa.teste.entity.Ponto;
import projeto.brisa.teste.services.PontoService;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/pontos")
@Api(value="Rest API Endereço")
@CrossOrigin(origins = "*")
public class PontoController {

	private PontoService pontoService;
	
	@PostMapping
	@ApiOperation(value = "Salva um Ponto")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PontoDTO> createdPonto(@RequestBody PontoDTO pontoDto) {
		return ResponseEntity.ok().body(pontoService.create(pontoDto));
	}
	@GetMapping
	@ApiOperation(value = "Retorna uma Lista de Contratos")
	public ResponseEntity<List<Ponto>> findAll() {
		return ResponseEntity.ok().body(pontoService.findAll());

	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta um Contrato")
	public PontoResponseDTO deletePonto(@PathVariable Long id) {
		return pontoService.del(id);
	}

	
	

}
