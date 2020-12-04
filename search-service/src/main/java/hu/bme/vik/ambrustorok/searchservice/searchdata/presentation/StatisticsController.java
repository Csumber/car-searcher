package hu.bme.vik.ambrustorok.searchservice.searchdata.presentation;

import hu.bme.vik.ambrustorok.searchservice.searchdata.service.StatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/statistics")
@AllArgsConstructor
public class StatisticsController {

    private StatisticsService service;

    @GetMapping("/clicks/user")
    public ResponseEntity<Map<String,Map<UUID,Integer>>> findAllClicksByUser() {
        return ResponseEntity.ok(service.findAllClicksByUser());
    }

    @GetMapping("/clicks/vehicle")
    public ResponseEntity<Map<UUID,Map<String,Integer>>> findAllClicksByVehicle() {
        return ResponseEntity.ok(service.findAllClicksByVehicle());
    }

    @GetMapping("/clicks/user/{username}")
    public ResponseEntity<Map<UUID,Integer>> findOneClickByUser(@PathVariable String username) {
        return ResponseEntity.ok(service.findOneClickByUser(username));
    }

    @GetMapping("/clicks/vehicle/{id}")
    public ResponseEntity<Map<String,Integer>> findONeClickByVehicle(@PathVariable UUID id) {
        return ResponseEntity.ok(service.findONeClickByVehicle(id));
    }

    @PostMapping("/clicks/vehicle/{id}/user/{username}")
    public ResponseEntity<Integer> increaseClicks(@PathVariable UUID id, @PathVariable String username) {
        return ResponseEntity.ok(service.increaseClicks(id, username));
    }

    @GetMapping("/min/{attribute}")
    public ResponseEntity<Map<String, ?>> findMinByAttribute(@PathVariable String attribute) {
        Map<String, ?> ret = service.getMin(attribute);
        if (ret == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(ret);
    }

    @GetMapping("/max/{attribute}")
    public ResponseEntity<Map<String, ?>> findMaxByAttribute(@PathVariable String attribute) {
        Map<String, ?> ret = service.getMax(attribute);
        if (ret == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(ret);
    }

    @GetMapping("/average/{attribute}")
    public ResponseEntity<Map<String, ?>> findAverageByAttribute(@PathVariable String attribute) {
        Map<String, ?> ret = service.getAverage(attribute);
        if (ret == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(ret);
    }

    @GetMapping("/mode/{attribute}")
    public ResponseEntity<Map<String, ?>> findModeByAttribute(@PathVariable String attribute) {
        Map<String, ?> ret = service.getMode(attribute);
        if (ret == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(ret);
    }

    @GetMapping("/median/{attribute}")
    public ResponseEntity<Map<String, ?>> findMedianByAttribute(@PathVariable String attribute) {
        Map<String, ?> ret = service.getMedian(attribute);
        if (ret == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(ret);
    }

    @GetMapping("/min/{attribute}/user/{username}")
    public ResponseEntity<?> findMinByAttributeByUser(@PathVariable String attribute, @PathVariable String username) {
        Map<String, ?> ret = service.getMin(attribute);
        if (ret == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(ret.get(username));
    }

    @GetMapping("/max/{attribute}/user/{username}")
    public ResponseEntity<?> findMaxByAttributeByUser(@PathVariable String attribute, @PathVariable String username) {
        Map<String, ?> ret = service.getMax(attribute);
        if (ret == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(ret.get(username));
    }

    @GetMapping("/average/{attribute}/user/{username}")
    public ResponseEntity<?> findAverageByAttributeByUser(@PathVariable String attribute, @PathVariable String username) {
        Map<String, ?> ret = service.getAverage(attribute);
        if (ret == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(ret.get(username));
    }

    @GetMapping("/mode/{attribute}/user/{username}")
    public ResponseEntity<?> findModeByAttributeByUser(@PathVariable String attribute, @PathVariable String username) {
        Map<String, ?> ret = service.getMode(attribute);
        if (ret == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(ret.get(username));
    }

    @GetMapping("/median/{attribute}/user/{username}")
    public ResponseEntity<?> findMedianByAttributeByUser(@PathVariable String attribute, @PathVariable String username) {
        Map<String, ?> ret = service.getMedian(attribute);
        if (ret == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(ret.get(username));
    }


}
