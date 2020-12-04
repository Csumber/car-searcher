package hu.bme.vik.ambrustorok.searchservice.searchdata.dto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;
import java.util.UUID;

@FeignClient(
        name = "search-service-statistics-v1",
        url = "localhost:8087/statistics",
        decode404 = true)
public interface StatisticsServiceClient {

    @GetMapping("/clicks/user")
    ResponseEntity<Map<String, Map<UUID, Integer>>> findAllClicksByUser();

    @GetMapping("/clicks/vehicle")
    ResponseEntity<Map<UUID, Map<String, Integer>>> findAllClicksByVehicle();

    @GetMapping("/clicks/user/{username}")
    ResponseEntity<Map<UUID, Integer>> findOneClickByUser(@PathVariable String username);

    @GetMapping("/clicks/vehicle/{id}")
    ResponseEntity<Map<String, Integer>> findOneClickByVehicle(@PathVariable UUID id);

    @PostMapping("/clicks/vehicle/{id}/user/{username}")
    ResponseEntity<Integer> increaseClicks(@PathVariable UUID id, @PathVariable String username);

    @GetMapping("/min/{attribute}")
    ResponseEntity<Map<String, ?>> findMinByAttribute(@PathVariable String attribute);

    @GetMapping("/max/{attribute}")
    ResponseEntity<Map<String, ?>> findMaxByAttribute(@PathVariable String attribute);

    @GetMapping("/average/{attribute}")
    ResponseEntity<Map<String, ?>> findAverageByAttribute(@PathVariable String attribute);

    @GetMapping("/mode/{attribute}")
    ResponseEntity<Map<String, ?>> findModeByAttribute(@PathVariable String attribute);

    @GetMapping("/median/{attribute}")
    ResponseEntity<Map<String, ?>> findMedianByAttribute(@PathVariable String attribute);

    @GetMapping("/min/{attribute}/user/{username}")
    ResponseEntity<?> findMinByAttributeByUser(@PathVariable String attribute, @PathVariable String username);

    @GetMapping("/max/{attribute}/user/{username}")
    ResponseEntity<?> findMaxByAttributeByUser(@PathVariable String attribute, @PathVariable String username);

    @GetMapping("/average/{attribute}/user/{username}")
    ResponseEntity<?> findAverageByAttributeByUser(@PathVariable String attribute, @PathVariable String username);

    @GetMapping("/mode/{attribute}/user/{username}")
    ResponseEntity<?> findModeByAttributeByUser(@PathVariable String attribute, @PathVariable String username);

    @GetMapping("/median/{attribute}/user/{username}")
    ResponseEntity<?> findMedianByAttributeByUser(@PathVariable String attribute, @PathVariable String username);

}
