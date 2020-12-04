package hu.bme.vik.ambrustorok.searchservice;

import hu.bme.vik.ambrustorok.searchservice.searchdata.dto.StatisticsServiceClient;
import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleResponse;
import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleServiceClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recommend")
@AllArgsConstructor
public class RecommenderController {

    private final StatisticsServiceClient statisticsServiceClient;
    private final VehicleServiceClient vehicleServiceClient;

    @GetMapping("/user/{username}/get")
    public ResponseEntity<Collection<VehicleResponse>> getRecommendation(@PathVariable String username) {
        List<VehicleResponse> vehicles = new ArrayList<>(vehicleServiceClient.findAll().getBody());
        Collections.shuffle(vehicles);
        return ResponseEntity.ok(vehicles.stream().limit(10).collect(Collectors.toList()));
    }

}
