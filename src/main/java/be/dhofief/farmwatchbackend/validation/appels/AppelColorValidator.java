package be.dhofief.farmwatchbackend.validation.appels;

import be.dhofief.farmwatchbackend.commons.AbstractValidationContext;
import be.dhofief.farmwatchbackend.commons.Processor;
import be.dhofief.farmwatchbackend.commons.SystemException;
import be.dhofief.farmwatchbackend.commons.ValidationException;
import be.dhofief.farmwatchbackend.entity.Appel;
import be.dhofief.farmwatchbackend.model.AppelModel;
import be.dhofief.farmwatchbackend.validation.AppelModelContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

import static java.util.stream.Collectors.toList;

@Component
public class AppelColorValidator implements Processor<AppelModelContext> {

    private final Collection<String> allowedColors;

    public AppelColorValidator(@Value("${farmwatchbackend.validation.appels.allowed-colors}")
            String[] allowedColors) {
        this.allowedColors = Arrays.stream(allowedColors).collect(toList());
    }

    @Override public AppelModelContext process(AppelModelContext appelModelContext) throws ValidationException, SystemException {

        String requestedColor = appelModelContext.getValidationSubject().getColor();

        if (!allowedColors.contains(requestedColor)) {
            ValidationException invalidColorException = invalidColorException(requestedColor);
            appelModelContext.addException(invalidColorException);
            throw invalidColorException;
        }

        return appelModelContext;
    }

    private ValidationException invalidColorException(String invalidColor) {
        return new ValidationException(String.format("Creating an apple with color %s is currently forbidden.", invalidColor));
    }

}
