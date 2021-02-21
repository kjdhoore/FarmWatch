package be.dhofief.farmwatchbackend.commons;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@NoArgsConstructor
public abstract class AbstractValidationContext<Model> implements ValidationContext<Model> {

    private Model subject;
    private Collection<ValidationException> validationExceptions = new ArrayList<>();

    @Override public Model getValidationSubject() {
        return subject;
    }

    @Override public void setValidationSubject(Model model) {
        this.subject = model;
    }

    @Override public Collection<ValidationException> getExceptions() {
        return validationExceptions;
    }

    @Override public void addException(ValidationException exception) {
        validationExceptions.add(exception);
    }
}
