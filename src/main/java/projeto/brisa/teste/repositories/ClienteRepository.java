package projeto.brisa.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.brisa.teste.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{

	public Cliente findByNome(String nome);

	
}
