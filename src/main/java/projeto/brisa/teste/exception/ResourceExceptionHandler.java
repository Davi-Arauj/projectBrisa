package projeto.brisa.teste.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.converter.HttpMessageNotReadableException;

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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandarError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
		
		ValidationError err = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validação", e.getMessage(), request.getRequestURI());
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	}	
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<StandarError> objectNotNull(HttpMessageNotReadableException e, HttpServletRequest request) {	
		StandarError err = new StandarError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Objeto não pode ser Nulo", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
}
