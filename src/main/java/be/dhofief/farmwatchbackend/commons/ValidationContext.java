package be.dhofief.farmwatchbackend.commons;

import java.util.Collection;

public interface ValidationContext<Model> {

    Model getValidationSubject();

    void setValidationSubject(Model m);

    Collection<ValidationException> getExceptions();

    void addException(ValidationException exception);

}
