package hu.bme.vik.ambrustorok.vehicleservice.engine.presentation;

import hu.bme.vik.ambrustorok.vehicleservice.engine.EngineDTO;
import hu.bme.vik.ambrustorok.vehicleservice.engine.EngineRegisterDTO;
import hu.bme.vik.ambrustorok.vehicleservice.engine.EngineServiceIF;
import hu.bme.vik.ambrustorok.vehicleservice.engine.data.EngineEntity;
import hu.bme.vik.ambrustorok.vehicleservice.engine.service.EngineService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/engine")
@AllArgsConstructor
public class EngineController implements EngineServiceIF {

    private EngineService service;
    private EngineMapper mapper;

    @GetMapping
    public ResponseEntity<Page<EngineDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable).map(mapper::EntityToDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EngineDTO> findOne(@PathVariable UUID id) {
        return service
                .findOne(id)
                .map(entity -> ResponseEntity.ok(mapper.EntityToDTO(entity)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EngineDTO> create(@RequestBody EngineRegisterDTO dto, UriComponentsBuilder b) {
        try {
            EngineEntity result = service.create(dto);

             UriComponents uriComponents = b.path("/investor/{id}").buildAndExpand(result.getId());
            return ResponseEntity.created(uriComponents.toUri()).body(mapper.EntityToDTO(result));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EngineDTO> modify(@PathVariable UUID id, @RequestBody EngineDTO dto) {

        try {
            EngineEntity result = service.update(id, dto);

            return ResponseEntity.ok(mapper.EntityToDTO(result));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {

        boolean isRemoved = service.delete(id);

        if (!isRemoved) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();

    }
}
