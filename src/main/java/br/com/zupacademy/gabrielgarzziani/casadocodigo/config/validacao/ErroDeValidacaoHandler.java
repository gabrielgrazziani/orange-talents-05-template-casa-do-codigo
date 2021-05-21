package br.com.zupacademy.gabrielgarzziani.casadocodigo.config.validacao;

import java.util.ArrayList;
import java.util.List;

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
	public List<ErroDeFormularioDto> handler(MethodArgumentNotValidException exception) {
		List<ErroDeFormularioDto> erros = new ArrayList<>();
		
		exception.getBindingResult().getGlobalErrors()
			.forEach(e -> {
				String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
				ErroDeFormularioDto dto = new ErroDeFormularioDto(e.getCode(),message);
				erros.add(dto);
			});
		
		exception.getBindingResult().getFieldErrors()
			.forEach(f ->{
				String message = messageSource.getMessage(f, LocaleContextHolder.getLocale());
				ErroDeFormularioDto dto = new ErroDeFormularioDto(f.getField(),message);
				erros.add(dto);
			});
		return erros;
	}
	
	@ExceptionHandler(ErroDeValidacaoException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErroDeFormularioDto handler(ErroDeValidacaoException exception) {
		return new ErroDeFormularioDto(exception.getCampo(), exception.getErro());
	}
}
