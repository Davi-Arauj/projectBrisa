package projeto.brisa.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import projeto.brisa.teste.entity.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Integer> {

	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Contrato obj WHERE obj.ponto.id =:pontoId")
	Contrato findByContratoByPonto(@Param("pontoId")Integer ponto_Id);

	
//	@Query("SELECT obj FROM Ponto obj WHERE obj.cliente.nome =:clienteNome AND obj.endereco.logradouro =:enderecoLogradouro")
//	Ponto findByClienteByEndereco(@Param("clienteNome")String cliente_Nome,@Param("enderecoLogradouro")String endereco_Logradouro);

}
