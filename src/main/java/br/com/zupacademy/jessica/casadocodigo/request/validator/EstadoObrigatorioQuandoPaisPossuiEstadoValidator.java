package br.com.zupacademy.jessica.casadocodigo.request.validator;

import br.com.zupacademy.jessica.casadocodigo.model.Estado;
import br.com.zupacademy.jessica.casadocodigo.request.CadastrarClienteRequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EstadoObrigatorioQuandoPaisPossuiEstadoValidator implements ConstraintValidator<EstadoObrigatorioQuandoPaisPossuiEstado, CadastrarClienteRequest> {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean isValid(CadastrarClienteRequest clienteRequest, ConstraintValidatorContext constraintValidatorContext) {
        final String colunaPais = "pais_nome";
        Query query = manager.createQuery(
                "select 1 from " + Estado.class.getName() + " where " + colunaPais + " = :pais");
        query.setParameter("pais", clienteRequest.getPais().getNome());
        List<?> result = query.getResultList();
        if (!result.isEmpty()) {
            return clienteRequest.getEstado() != null;
        }
        return true;
    }
}
