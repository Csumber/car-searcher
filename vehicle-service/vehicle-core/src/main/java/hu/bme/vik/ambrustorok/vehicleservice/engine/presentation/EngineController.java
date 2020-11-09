package hu.bme.vik.ambrustorok.vehicleservice.engine.presentation;

import hu.bme.vik.ambrustorok.vehicleservice.engine.EngineDTO;
import hu.bme.vik.ambrustorok.vehicleservice.engine.EngineRegisterDTO;
import hu.bme.vik.ambrustorok.vehicleservice.engine.data.EngineEntity;
import hu.bme.vik.ambrustorok.vehicleservice.engine.service.EngineService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/engine")
@AllArgsConstructor
public class EngineController {

    private EngineService service;
    private EngineMapper mapper;

    @GetMapping
    public ResponseEntity<Page<EngineDTO>> findAllEngines(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable).map(mapper::engineToDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EngineDTO> findOneEngine(@PathVariable UUID id) {
        return service
                .findOne(id)
                .map(entity -> ResponseEntity.ok(mapper.engineToDTO(entity)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<EngineDTO> createEngine(@RequestBody EngineRegisterDTO investor, UriComponentsBuilder b) {
        try {
            // Létrehozuk az entitást
            EngineEntity result = service.create(investor);

            // A szabvány szerint a header-ben vissza kell adjuk az új entitás helyét, így kénytelenk vagyunk felépíteni az URL-t
            UriComponents uriComponents = b.path("/investor/{id}").buildAndExpand(result.getId());
            return ResponseEntity.created(uriComponents.toUri()).body(mapper.engineToDTO(result));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EngineDTO> modifyEngine(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build(); //TODO: implement
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEngine(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build(); //TODO: implement
    }
}
