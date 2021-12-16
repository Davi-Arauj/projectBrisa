package projeto.brisa.teste;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.AllArgsConstructor;
import projeto.brisa.teste.entity.Cliente;
import projeto.brisa.teste.entity.Contrato;
import projeto.brisa.teste.entity.Endereco;
import projeto.brisa.teste.entity.HistoricoContrato;
import projeto.brisa.teste.entity.Ponto;
import projeto.brisa.teste.enums.ClienteType;
import projeto.brisa.teste.enums.ContratoType;
import projeto.brisa.teste.repositories.ClienteRepository;
import projeto.brisa.teste.repositories.ContratoRepository;
import projeto.brisa.teste.repositories.EnderecoRepository;
import projeto.brisa.teste.repositories.HistoricoRepository;
import projeto.brisa.teste.repositories.PontoRepository;

//@ComponentScan(basePackages = {"projeto.brisa.teste.services"})
@SpringBootApplication
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TesteApplication implements CommandLineRunner {
	
	private ClienteRepository clienteRepository;
	private EnderecoRepository enderecoRepository;
	private ContratoRepository contratoRepository;
	private PontoRepository pontoRepository;
	private HistoricoRepository hcRepository;


	    public static void main(String[] args) {
	        SpringApplication.run(TesteApplication.class, args);
	    }
	    
	    @Override
		public void run(String... args) throws Exception {	
	    	
	    	Cliente cliente = new Cliente();
	    	Endereco endereco = new Endereco();
	    	Ponto ponto = new Ponto();
	    	Contrato contrato =new Contrato();
	    	
	    	cliente.setNome("Davi");
	    	cliente.setTipo(ClienteType.FISICO);
	    	clienteRepository.save(cliente);
	    	
	    	endereco.setLogradouro("Rua do Limoerio");
	    	endereco.setBairro("Franciscano");
	    	endereco.setNumero(1084);
	    	enderecoRepository.save(endereco);
	 
	    	ponto.setCliente(cliente);
	    	ponto.setEndereco(endereco);
	    	pontoRepository.save(ponto);
	    	
	    	contrato.setPonto(ponto);
	    	contratoRepository.save(contrato);
	    	
	    	HistoricoContrato hc = new HistoricoContrato();
			hc.setDataEvento(new Date());
			hc.setEstadoAntigo(ContratoType.EM_VIGOR);
			hc.setContrato(contrato);
			hcRepository.save(hc);
	    	
	    		}
	
}
