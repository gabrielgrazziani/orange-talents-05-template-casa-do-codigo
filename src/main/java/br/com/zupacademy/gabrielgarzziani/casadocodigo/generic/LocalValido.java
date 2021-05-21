package br.com.zupacademy.gabrielgarzziani.casadocodigo.generic;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.zupacademy.gabrielgarzziani.casadocodigo.local.EstadoValidator;

@Documented
@Constraint(validatedBy = {EstadoValidator.class})
@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface LocalValido {
	
	String getCode() default "";
	
	String message() default "Dados do local estão incorretos";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}