package projeto.brisa.teste.exception;

public class DataIntegrityException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DataIntegrityException(String msg) {
		super("O objeto já Existe");	
	}

}
