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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import projeto.brisa.teste.dto.ContratoDTO;
import projeto.brisa.teste.dto.response.ContratoResponseDTO;
import projeto.brisa.teste.entity.Contrato;
import projeto.brisa.teste.entity.HistoricoContrato;
import projeto.brisa.teste.services.ContratoService;
import projeto.brisa.teste.services.HistoricoService;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/contratos")
@Api(value = "Api Rest Contratos")
@CrossOrigin(origins = "*")
public class ContratoController {

	private ContratoService contratotoService;
	
	private HistoricoService hcService;
	
	//Salva um Contrato
	@PostMapping
	@ApiOperation(value = "Salva um Contrato")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ContratoDTO> createdContrato(@RequestBody ContratoDTO contratoDto) {
		return ResponseEntity.ok().body(contratotoService.create(contratoDto));
	}
	
	//Retorna uma Lista Contrato
	@GetMapping
	@ApiOperation(value = "Retorna uma Lista Contrato")
	public ResponseEntity<List<Contrato>> findAll() {
		return ResponseEntity.ok().body(contratotoService.findAll());

	}
	
	//Deletar um Contrato
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletar um Contrato")
	public ContratoResponseDTO deleteContrato(@PathVariable Long id) {
		return contratotoService.del(id);
	}

	//Retorna um Contrato
	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um Contrato")
	public ResponseEntity<Contrato> findContrato(@PathVariable Long id) {
		return ResponseEntity.ok().body(contratotoService.findId(id));
	} 
	
	//Retorna as Movimentações de um Contrato
	@GetMapping("/{id}/historico")
	@ApiOperation(value = "Retorna as Movimentações de um Contrato")
	public ResponseEntity<HistoricoContrato> findHistoricoContrato(@PathVariable Long id) {
		return ResponseEntity.ok().body(hcService.findId(id));
	}

	//Atualiza o estado do Contrato
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza o estado de um Contrato")
	public ContratoResponseDTO updateContrato(@PathVariable Long id,@RequestBody ContratoDTO cont){		
		return contratotoService.updateContrato(id, cont);
	}


}
