package br.com.zupacademy.jessica.casadocodigo.request.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {EstadoObrigatorioQuandoPaisPossuiEstadoValidator.class})
@Target({ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface EstadoObrigatorioQuandoPaisPossuiEstado {
    String message() default "Obrigatório informar um estado para este país";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
