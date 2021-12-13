package projeto.brisa.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.brisa.teste.entity.Cliente;
import projeto.brisa.teste.entity.Ponto;

public interface PontoRepository extends JpaRepository<Ponto,Integer>{


}
