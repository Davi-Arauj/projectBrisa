package projeto.brisa.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projeto.brisa.teste.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco,Integer>{

	@Query("SELECT obj FROM Endereco obj WHERE obj.logradouro =:logradouro AND obj.numero =:numero")
	Endereco findByLogradouroByNumero(@Param("logradouro")String logradouro,@Param("numero")Integer numero);

	
}
