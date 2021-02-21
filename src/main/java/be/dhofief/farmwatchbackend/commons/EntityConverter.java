package be.dhofief.farmwatchbackend.commons;

public interface EntityConverter<Entity, Model> {

    Entity toEntity(Model model);

    Model toModel(Entity entity);

}
