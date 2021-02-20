package be.dhofief.farmwatchbackend.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
public class AppelDTO {

    @JsonProperty
    private final String color;

    @JsonProperty
    private final Integer age;

}
