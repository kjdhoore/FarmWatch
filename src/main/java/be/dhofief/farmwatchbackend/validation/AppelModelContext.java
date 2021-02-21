package be.dhofief.farmwatchbackend.validation;

import be.dhofief.farmwatchbackend.commons.AbstractValidationContext;
import be.dhofief.farmwatchbackend.model.AppelModel;

public class AppelModelContext extends AbstractValidationContext<AppelModel> {

    public static AppelModelContext of(AppelModel model) {
        AppelModelContext context = new AppelModelContext();
        context.setValidationSubject(model);
        return context;
    }

}
