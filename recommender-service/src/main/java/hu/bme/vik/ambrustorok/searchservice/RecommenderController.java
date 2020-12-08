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

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recommend")
@AllArgsConstructor
public class RecommenderController {

    private final StatisticsServiceClient statisticsServiceClient;
    private final VehicleServiceClient vehicleServiceClient;

    @GetMapping("/user/{username}/get")
    public ResponseEntity<Collection<VehicleResponse>> getRecommendation(@PathVariable String username) {
        double maxPrice;
        List<VehicleResponse> vehicles = new ArrayList<>(Objects.requireNonNull(vehicleServiceClient.findAll().getBody()));
        Map<UUID, Map<String, Integer>> vehicleClicks = statisticsServiceClient.findAllClicksByVehicle().getBody();

        List<Entry<UUID, Map<String, Integer>>> list = new ArrayList<>(vehicleClicks.entrySet());
        Collections.sort(list, new ClickComparator());

        try {
            Object maxPriceO = statisticsServiceClient.findMaxByAttributeByUser("maxprice", username);
            maxPrice = (double) maxPriceO;
        } catch (ClassCastException e) {

            for (Entry<UUID, Map<String, Integer>> uuidMapEntry : list) {
                VehicleResponse vehicleResponse = vehicleServiceClient.findOne(uuidMapEntry.getKey()).getBody();
                vehicles.add(vehicleResponse);
            }
            return ResponseEntity.ok(vehicles.stream().limit(10).collect(Collectors.toList()));
        }

        for (Entry<UUID, Map<String, Integer>> uuidMapEntry : list) {
            VehicleResponse vehicleResponse = vehicleServiceClient.findOne(uuidMapEntry.getKey()).getBody();
            if (vehicleResponse != null)
                if (vehicleResponse.getPrice() < maxPrice)
                    vehicles.add(vehicleResponse);
        }
        return ResponseEntity.ok(vehicles.stream().limit(10).collect(Collectors.toList()));
    }

}
