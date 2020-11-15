package hu.bme.vik.ambrustorok.vehicleservice.option.presentation;

import hu.bme.vik.ambrustorok.vehicleservice.option.OptionDTO;
import hu.bme.vik.ambrustorok.vehicleservice.option.OptionRegisterDTO;
import hu.bme.vik.ambrustorok.vehicleservice.option.data.OptionEntity;
import hu.bme.vik.ambrustorok.vehicleservice.option.service.OptionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;


@RestController
@RequestMapping("/option")
@AllArgsConstructor
public class OptionController {

    private OptionService service;
    private OptionMapper mapper;

    @GetMapping
    public ResponseEntity<Page<OptionDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable).map(mapper::EntityToDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OptionDTO> findOne(@PathVariable UUID id) {
        return service
                .findOne(id)
                .map(entity -> ResponseEntity.ok(mapper.EntityToDTO(entity)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OptionDTO> create(@RequestBody OptionRegisterDTO dto, UriComponentsBuilder b) {
        try {
            OptionEntity result = service.create(dto);

            UriComponents uriComponents = b.path("/investor/{id}").buildAndExpand(result.getId());
            return ResponseEntity.created(uriComponents.toUri()).body(mapper.EntityToDTO(result));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<OptionDTO> modify(@PathVariable UUID id, @RequestBody OptionDTO dto) {

        try {
            OptionEntity result = service.update(id, dto);

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