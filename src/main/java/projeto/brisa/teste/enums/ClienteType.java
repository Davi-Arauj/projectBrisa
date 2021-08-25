package projeto.brisa.teste.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClienteType {
	 
		JURIDICO("Juridico"),
	    FISICO("Fisico"),
	    ESPECIAL("Especial");

	    ClienteType(String string) {
	    	 String	description = string;
		}
}
