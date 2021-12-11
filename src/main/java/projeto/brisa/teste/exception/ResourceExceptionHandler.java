package projeto.brisa.teste.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(DataDuplicateException.class)
	public ResponseEntity<StandarError> objectDuplicate(DataDuplicateException e, HttpServletRequest request) {	
		StandarError err = new StandarError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Registro Duplicado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {	
		StandarError err = new StandarError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Objeto não existe", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
