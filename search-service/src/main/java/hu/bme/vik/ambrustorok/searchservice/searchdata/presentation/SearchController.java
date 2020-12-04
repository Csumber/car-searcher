package hu.bme.vik.ambrustorok.searchservice.searchdata.presentation;

import hu.bme.vik.ambrustorok.searchservice.searchdata.data.SearchEntity;
import hu.bme.vik.ambrustorok.searchservice.searchdata.dto.SearchRequest;
import hu.bme.vik.ambrustorok.searchservice.searchdata.dto.SearchResponse;
import hu.bme.vik.ambrustorok.searchservice.searchdata.service.SearchService;
import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleResponse;
import lombok.AllArgsConstructor;
import org.h2.util.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/search")
@AllArgsConstructor
public class SearchController {

    private SearchService service;
    private SearchMapper mapper;

    @PostMapping
    public ResponseEntity<Collection<VehicleResponse>> search(@RequestBody SearchRequest search) {
        if (!StringUtils.isNullOrEmpty(search.getUsername())) {

            if (search.getLengthMax() < search.getLengthMin())
                return ResponseEntity.badRequest().build();
            if (search.getNumberOfDoorsMax() < search.getNumberOfDoorsMin())
                return ResponseEntity.badRequest().build();
            if (search.getPriceMax() < search.getPriceMin())
                return ResponseEntity.badRequest().build();
            if (search.getWarrantyMax() < search.getWarrantyMin())
                return ResponseEntity.badRequest().build();
            if (search.getWeightMax() < search.getWeightMin())
                return ResponseEntity.badRequest().build();
            if (search.getWidthMax() < search.getWidthMin())
                return ResponseEntity.badRequest().build();
            if (StringUtils.isNullOrEmpty(search.getManufacturer()))
                service.create(search);
        }
        Collection<VehicleResponse> results = service.search(search);
        if (results == null || results.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(results);
    }

    @GetMapping
    public ResponseEntity<Collection<SearchResponse>> findAll() {
        return ResponseEntity.ok(service.findAll().stream().map(mapper::EntityToDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SearchResponse> findOne(@PathVariable UUID id) {
        return service
                .findOne(id)
                .map(entity -> ResponseEntity.ok(mapper.EntityToDTO(entity)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SearchResponse> modify(@PathVariable UUID id, @RequestBody SearchRequest dto) {

        try {
            SearchEntity result = service.update(id, dto);

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

    @GetMapping("/user/{username}")
    public ResponseEntity<Collection<SearchResponse>> findByUsername(@PathVariable String username) {
        return ResponseEntity.ok(service.findByUsername(username).stream().map(mapper::EntityToDTO).collect(Collectors.toList()));
    }
}
