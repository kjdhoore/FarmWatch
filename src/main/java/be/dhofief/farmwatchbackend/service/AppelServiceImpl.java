package be.dhofief.farmwatchbackend.service;

import be.dhofief.farmwatchbackend.commons.AbstractValidationContextProcessor;
import be.dhofief.farmwatchbackend.commons.SystemException;
import be.dhofief.farmwatchbackend.commons.ValidationException;
import be.dhofief.farmwatchbackend.entity.Appel;
import be.dhofief.farmwatchbackend.entity.AppelConverter;
import be.dhofief.farmwatchbackend.model.AppelModel;
import be.dhofief.farmwatchbackend.repository.AppelRepository;
import be.dhofief.farmwatchbackend.validation.AppelModelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppelServiceImpl implements AppelService {

    private final AppelConverter appelConverter;
    private final AppelRepository appelRepository;
    private final AbstractValidationContextProcessor<AppelModel, AppelModelContext> appelValidationProcessor;

    @Autowired
    public AppelServiceImpl(
            AppelConverter appelConverter,
            AppelRepository appelRepository,
            AbstractValidationContextProcessor<AppelModel, AppelModelContext> appelValidationProcessor
    ) {
        this.appelConverter = appelConverter;
        this.appelRepository = appelRepository;
        this.appelValidationProcessor = appelValidationProcessor;
    }

    @Override public AppelModel createFixedAppel() {
        Appel createdAppel = appelRepository.save(new Appel(null, "blue", 3));
        System.out.printf("Created appel: %s%n", createdAppel);
        return appelConverter.toModel(
                createdAppel
        );
    }

    @Override public AppelModel getAppel(String id) {
        return appelConverter.toModel(
                appelRepository.getOne(id)
        );
    }

    @Override public AppelModel createAppel(AppelModel appelModel) throws ValidationException, SystemException {
        // Check if the incoming appel is valid.
        // If it is not, a validaitonException will be thrown by appelValidationProcessor, with appropriate status code.
        AppelModel validAppelModel = appelValidationProcessor.process(appelModel);
        // If we reach this line, the appelModel is valid.
        Appel created = appelRepository.save(appelConverter.toEntity(validAppelModel));
        return appelConverter.toModel(created);
    }

}
