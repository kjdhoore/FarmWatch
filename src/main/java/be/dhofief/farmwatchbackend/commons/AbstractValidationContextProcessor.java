package be.dhofief.farmwatchbackend.commons;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public abstract class AbstractValidationContextProcessor<Model, Context extends AbstractValidationContext<Model>> implements ValidationContextProcessor<Model, Context> {

    private final List<Processor<Context>> orderedValidationContextProcessors;

    public AbstractValidationContextProcessor(
            List<Processor<Context>> validationProcessors
    ) {
        this.orderedValidationContextProcessors = validationProcessors;
    }

    public Model process(Model model, Function<Model, Context> contextSupplier) throws ValidationException, SystemException {
        Context modelValidationContext = contextSupplier.apply(model);

        try {

            modelValidationContext = processAll(orderedValidationContextProcessors, modelValidationContext);

        } catch (Exception actualThrownException) {

            handleException(actualThrownException, modelValidationContext.getExceptions());

        }

        return modelValidationContext.getValidationSubject();
    }

    public abstract Model process(Model model) throws ValidationException, SystemException;

    private Context processAll(
            List<Processor<Context>> orderedModelProcessors,
            Context modelValidationContext
    ) throws ValidationException, SystemException {
        for (Processor<Context> processor : orderedModelProcessors) {
            modelValidationContext = processor.process(modelValidationContext);
        }
        return modelValidationContext;
    }

    private void handleException(
            Exception actualThrownException,
            Collection<ValidationException> validationExceptions
    ) throws SystemException, ValidationException {
        if (actualThrownException instanceof ValidationException) {
            // Print internally alle tegengekomen warnings / exceptions
            List<ValidationException> orderedExceptions = new ArrayList<>(validationExceptions);
            for (ValidationException exception : orderedExceptions) {
                System.out.printf("AppelValidationException encountered: %s\n", exception.getMessage());
            }
            throw (ValidationException) actualThrownException;

        } else {
            System.out.println("Misschien hadden we toch beter moeten testen");
            throw new SystemException("Internal server error during AppelValidation", actualThrownException);
        }
    }
}
