package be.dhofief.farmwatchbackend.entity;

import be.dhofief.farmwatchbackend.commons.EntityConverter;
import be.dhofief.farmwatchbackend.model.AppelModel;
import org.springframework.stereotype.Component;

@Component
public class AppelConverter implements EntityConverter<Appel, AppelModel> {

    public Appel toEntity(AppelModel model) {
        return new Appel(model.getId(), model.getColor(), model.getAge());
    }

    public AppelModel toModel(Appel entity) {
        return AppelModel.builder()
                .id(entity.getId())
                .age(entity.getAge())
                .color(entity.getColor())
                .build();
    }

}
