package br.com.zupacademy.gabrielgarzziani.casadocodigo.config.validacao;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroDeValidacaoHandler {
	
	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Stream<Object> handler(MethodArgumentNotValidException exception) {
		return exception.getBindingResult().getFieldErrors()
			.stream()
			.map(f ->{
				String message = messageSource.getMessage(f, LocaleContextHolder.getLocale());
				return new ErroDeFormularioDto(f.getField(),message);
			});
	}
}
