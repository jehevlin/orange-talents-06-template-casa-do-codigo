package br.com.zupacademy.jessica.casadocodigo.request.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {EstadoUnicoPorPaisValidator.class})
@Target({ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface EstadoUnicoPorPais {

    String message() default "Nome de estado já existe nesse país";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
