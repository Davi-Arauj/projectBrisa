package projeto.brisa.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import projeto.brisa.teste.dto.ContratoDTO;
import projeto.brisa.teste.dto.response.ContratoResponseDTO;
import projeto.brisa.teste.entity.Contrato;
import projeto.brisa.teste.entity.HistoricoContrato;
import projeto.brisa.teste.services.ContratoService;
import projeto.brisa.teste.services.HistoricoService;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/contratos")
public class ContratoController {

	private ContratoService contratotoService;
	
	private HistoricoService hcService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ContratoDTO> createdContrato(@RequestBody ContratoDTO contratoDto) {
		return ResponseEntity.ok().body(contratotoService.create(contratoDto));
	}
	
	@GetMapping
	public ResponseEntity<List<Contrato>> findAll() {
		return ResponseEntity.ok().body(contratotoService.findAll());

	}
	
	@DeleteMapping("/{id}")
	public ContratoResponseDTO deleteContrato(@PathVariable Integer id) {
		return contratotoService.del(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Contrato> findContrato(@PathVariable Integer id) {
		return ResponseEntity.ok().body(contratotoService.findId(id));
	} 
	
	@GetMapping("/{id}/historico")
	public ResponseEntity<HistoricoContrato> findHistoricoContrato(@PathVariable Integer id) {
		return ResponseEntity.ok().body(hcService.findId(id));
	}

	//Atualiza o estado do Contrato
	@PutMapping("/{id}")
	public ContratoResponseDTO updateContrato(@PathVariable Integer id,@RequestBody ContratoDTO cont){		
		return contratotoService.updateContrato(id, cont);
	}


}
