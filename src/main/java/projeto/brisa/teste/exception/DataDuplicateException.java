package projeto.brisa.teste.exception;

public class DataDuplicateException extends RuntimeException{


	private static final long serialVersionUID = 1L;

	public DataDuplicateException(String msg) {
		super(msg);
	}
	
}
