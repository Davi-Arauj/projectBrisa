package projeto.brisa.teste.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import projeto.brisa.teste.dto.ClienteDTO;
import projeto.brisa.teste.entity.Cliente;

@Mapper
public interface ClienteMapper {

	ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

	    Cliente toModel(ClienteDTO clienteDTO);
	    ClienteDTO toDTO(Cliente cliente);
}
