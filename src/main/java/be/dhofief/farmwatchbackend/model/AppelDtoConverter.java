package be.dhofief.farmwatchbackend.model;

import be.dhofief.farmwatchbackend.commons.DtoConverter;
import be.dhofief.farmwatchbackend.controller.dto.AppelDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppelDtoConverter implements DtoConverter<AppelDTO, AppelModel> {

    public AppelDTO toDto(AppelModel model) {
        return AppelDTO.builder()
                .age(model.getAge())
                .color(model.getColor())
                .build();
    }

    public AppelModel toModel(AppelDTO dto) {
        return AppelModel.builder()
                .id(null)
                .age(dto.getAge())
                .color(dto.getColor())
                .build();
    }
}
