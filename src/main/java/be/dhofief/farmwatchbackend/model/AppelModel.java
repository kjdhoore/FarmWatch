package be.dhofief.farmwatchbackend.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class AppelModel {

    private String id;

    private String color;

    private Integer age;

}
