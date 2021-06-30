package br.com.zupacademy.jessica.casadocodigo.request.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {MustBeUniqueValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface MustBeUnique {
    String message() default "Valor já cadastrado";

    Class<?> [] groups() default {};

    Class<? extends Payload>[] playload() default {};

    Class<?> domainClass();

    String fieldName();

}
