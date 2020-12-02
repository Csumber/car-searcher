package hu.bme.vik.ambrustorok.searchservice.searchdata.presentation;

import hu.bme.vik.ambrustorok.searchservice.searchdata.dto.SearchResponse;
import hu.bme.vik.ambrustorok.searchservice.searchdata.service.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/statistics")
@AllArgsConstructor
public class StatisticsController {

    private SearchService service;
    private SearchMapper mapper;

    @GetMapping("/clicks/user")
    public ResponseEntity<Collection<SearchResponse>> findAllClicksByUser() {
        return null;
    }

    @GetMapping("/clicks/vehicle")
    public ResponseEntity<Collection<SearchResponse>> findAllClicksByVehicle() {
        return null;
    }

    @GetMapping("/clicks/user/{username}")
    public ResponseEntity<Collection<SearchResponse>> findOneClickByUser(@PathVariable String username) {
        return null;
    }

    @GetMapping("/clicks/vehicle/{id}")
    public ResponseEntity<Collection<SearchResponse>> findONeClickByVehicle(@PathVariable UUID id) {
        return null;
    }

    @GetMapping("/average/{attribute}")
    public ResponseEntity<Collection<SearchResponse>> findAverageByAttribute(@PathVariable String attribute) {
        return null;
    }

    @GetMapping("/median/{attribute}")
    public ResponseEntity<Collection<SearchResponse>> findMedianByAttribute(@PathVariable String attribute) {
        return null;
    }

    @GetMapping("/modus/{attribute}")
    public ResponseEntity<Collection<SearchResponse>> findModusByAttribute(@PathVariable String attribute) {
        return null;
    }

    @GetMapping("/average/{attribute}/user/{username}")
    public ResponseEntity<Collection<SearchResponse>> findAverageByAttributeByUser(@PathVariable String attribute, @PathVariable String username) {
        return null;
    }

    @GetMapping("/median/{attribute}/user/{username}")
    public ResponseEntity<Collection<SearchResponse>> findMedianByAttributeByUser(@PathVariable String attribute, @PathVariable String username) {
        return null;
    }

    @GetMapping("/modus/{attribute}/user/{username}")
    public ResponseEntity<Collection<SearchResponse>> findModusByAttributeByUser(@PathVariable String attribute, @PathVariable String username) {
        return null;
    }


}
