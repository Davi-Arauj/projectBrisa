package projeto.brisa.teste.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import projeto.brisa.teste.enums.ClienteType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {

	private Integer id;
	
	@NotNull
	@Size(min = 0, max = 200)
	private String name;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private ClienteType type;
}
