package be.dhofief.farmwatchbackend.validation;

import be.dhofief.farmwatchbackend.commons.AbstractValidationContext;
import be.dhofief.farmwatchbackend.commons.AbstractValidationContextProcessor;
import be.dhofief.farmwatchbackend.commons.Processor;
import be.dhofief.farmwatchbackend.commons.SystemException;
import be.dhofief.farmwatchbackend.commons.ValidationException;
import be.dhofief.farmwatchbackend.model.AppelModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class AppelValidationProcessor extends AbstractValidationContextProcessor<AppelModel, AppelModelContext> {

    @Autowired
    public AppelValidationProcessor(
            List<Processor<AppelModelContext>> validationProcessors) {
        super(validationProcessors);
    }

    @Override public AppelModel process(AppelModel appelModel) throws ValidationException, SystemException {
        return process(appelModel, AppelModelContext::of);
    }

}
