package be.dhofief.farmwatchbackend.commons;

public interface Processor<ValidationContext> {

    ValidationContext process(ValidationContext model) throws ValidationException, SystemException;

}
