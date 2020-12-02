package hu.bme.vik.ambrustorok.searchservice.searchdata.presentation;

import hu.bme.vik.ambrustorok.searchservice.controller.searchdata.service.SearchService;
import hu.bme.vik.ambrustorok.vehicleservice.dto.engine.EngineRequest;
import hu.bme.vik.ambrustorok.vehicleservice.dto.engine.EngineResponse;
import hu.bme.vik.ambrustorok.vehicleservice.engine.data.EngineEntity;
import hu.bme.vik.ambrustorok.vehicleservice.engine.service.EngineServiceIF;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/statistics")
@AllArgsConstructor
public class StatisticsController implements EngineServiceIF {

    private SearchService service;
    private SearchMapper mapper;

    @GetMapping
    public ResponseEntity<Collection<EngineResponse>> findAll() {
        return ResponseEntity.ok(service.findAll().stream().map(mapper::EntityToDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EngineResponse> findOne(@PathVariable UUID id) {
        return service
                .findOne(id)
                .map(entity -> ResponseEntity.ok(mapper.EntityToDTO(entity)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EngineResponse> create(@RequestBody EngineRequest dto, UriComponentsBuilder b) {
        try {
            EngineEntity result = service.create(dto);

            UriComponents uriComponents = b.path("/investor/{id}").buildAndExpand(result.getId());
            return ResponseEntity.created(uriComponents.toUri()).body(mapper.EntityToDTO(result));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EngineResponse> modify(@PathVariable UUID id, @RequestBody EngineResponse dto) {

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
