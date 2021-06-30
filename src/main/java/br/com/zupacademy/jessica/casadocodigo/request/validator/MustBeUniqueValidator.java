package br.com.zupacademy.jessica.casadocodigo.request.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class MustBeUniqueValidator implements ConstraintValidator<MustBeUnique, Object> {
    private String domainField;
    private Class<?> domainClass;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(MustBeUnique constrainAnnotation) {
        domainField = constrainAnnotation.fieldName();
        domainClass = constrainAnnotation.domainClass();
    }

    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = manager.createQuery(
                "select 1 from " + domainClass.getName() + " where " + domainField + " = :value");
        query.setParameter("value", value);
        List<?> result = query.getResultList();
        return result.isEmpty();
    }
}
