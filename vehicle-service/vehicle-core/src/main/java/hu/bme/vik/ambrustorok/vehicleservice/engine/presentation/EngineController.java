package hu.bme.vik.ambrustorok.vehicleservice.engine.presentation;

import hu.bme.vik.ambrustorok.vehicleservice.dto.engine.EngineRequest;
import hu.bme.vik.ambrustorok.vehicleservice.dto.engine.EngineResponse;
import hu.bme.vik.ambrustorok.vehicleservice.engine.data.EngineEntity;
import hu.bme.vik.ambrustorok.vehicleservice.dto.engine.EngineServiceClient;
import hu.bme.vik.ambrustorok.vehicleservice.engine.service.EngineServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/engine")
@AllArgsConstructor
public class EngineController implements EngineServiceClient {

    private final EngineServiceImpl service;
    private final EngineMapper mapper;

    @GetMapping("/model")
    public ResponseEntity<ModelMap> model(ModelMap model, Authentication authentication) {
        model.addAttribute("name", authentication.getName());
        model.addAttribute("authorities", authentication.getAuthorities());
        return ResponseEntity.ok(model);
    }

    @GetMapping("/getAuthorities")
    public ResponseEntity<Collection<? extends GrantedAuthority>> getAuthorities(ModelMap model, Authentication authentication) {
        model.addAttribute("name", authentication.getName());
        return ResponseEntity.ok(new ArrayList<>(authentication.getAuthorities()));
    }

    @GetMapping("/getCredentials")
    public ResponseEntity<Object> getCredentials(ModelMap model, Authentication authentication) {
        model.addAttribute("name", authentication.getName());
        return ResponseEntity.ok(authentication.getCredentials());
    }

    @GetMapping("/getDetails")
    public ResponseEntity<Object> getDetails(ModelMap model, Authentication authentication) {
        model.addAttribute("name", authentication.getName());
        return ResponseEntity.ok(authentication.getDetails());
    }

    @GetMapping("/getPrincipal")
    public ResponseEntity<Object> getPrincipal(ModelMap model, Authentication authentication) {
        model.addAttribute("name", authentication.getName());
        return ResponseEntity.ok(authentication.getPrincipal());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EngineResponse> findOne(@PathVariable UUID id) {
        return service.findOne(id).map(engineEntity -> ResponseEntity.ok(mapper.EntityToDTO(engineEntity))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Collection<EngineResponse>> findAll() {
        return ResponseEntity.ok(service.findAll().stream().map(mapper::EntityToDTO).collect(Collectors.toList()));
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
