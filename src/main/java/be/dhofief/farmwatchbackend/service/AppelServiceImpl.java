package be.dhofief.farmwatchbackend.service;

import be.dhofief.farmwatchbackend.entity.Appel;
import be.dhofief.farmwatchbackend.entity.AppelConverter;
import be.dhofief.farmwatchbackend.model.AppelModel;
import be.dhofief.farmwatchbackend.repository.AppelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppelServiceImpl implements AppelService {

    private final AppelConverter appelConverter;
    private final AppelRepository appelRepository;

    @Autowired
    public AppelServiceImpl(
            AppelConverter appelConverter,
            AppelRepository appelRepository
    ) {
        this.appelConverter = appelConverter;
        this.appelRepository = appelRepository;
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

}
