package be.dhofief.farmwatchbackend.commons;

public interface DtoConverter<Dto, Model>{

    Dto toDto(Model model);

    Model toModel(Dto dto);

}
