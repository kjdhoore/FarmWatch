package be.dhofief.farmwatchbackend.commons;

import java.util.function.Function;

public interface ValidationContextProcessor<Model, Context> {

    Model process(Model model, Function<Model, Context> contextSupplier) throws ValidationException, SystemException;
    Model process(Model model) throws ValidationException, SystemException;

}
