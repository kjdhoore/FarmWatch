package be.dhofief.farmwatchbackend.controller.dto;

import be.dhofief.farmwatchbackend.commons.SystemException;
import be.dhofief.farmwatchbackend.commons.ValidationException;
import be.dhofief.farmwatchbackend.model.AppelDtoConverter;
import be.dhofief.farmwatchbackend.service.AppelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppelController {

    private final AppelDtoConverter appelDtoConverter;
    private final AppelService appelService;

    @Autowired
    public AppelController(
            AppelDtoConverter appelDtoConverter,
            AppelService appelService
    ) {
        this.appelDtoConverter = appelDtoConverter;
        this.appelService = appelService;
    }

    @GetMapping("/appels")
    public ResponseEntity<AppelDTO> getAppel() {
        return ResponseEntity.ok(
                appelDtoConverter.toDto(
                        appelService.createFixedAppel()
                )
        );
    }

    @GetMapping("/appels/{id}")
    public ResponseEntity<AppelDTO> getAppel(@PathVariable("id") String id) {
        return ResponseEntity.ok(
                appelDtoConverter.toDto(
                        appelService.getAppel(id)
                )
        );
    }

    @PostMapping("/appels")
    public ResponseEntity<AppelDTO> createAppel(@RequestBody AppelDTO appelDTO) throws ValidationException, SystemException {
        return ResponseEntity.ok(
                appelDtoConverter.toDto(
                        appelService.createAppel(
                                appelDtoConverter.toModel(
                                        appelDTO
                                )
                        )
                )
        );
    }
}
