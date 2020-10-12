package bme.vik.ambrustorok.vehicleservice.controllers;

import bme.vik.ambrustorok.vehicleservice.model.Vehicle;
import bme.vik.ambrustorok.vehicleservice.payload.request.VehicleRequest;
import bme.vik.ambrustorok.vehicleservice.repository.EngineRepository;
import bme.vik.ambrustorok.vehicleservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    EngineRepository engineRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @PostMapping("/vehicles")
    public String addNewVehicle(@Valid @RequestBody VehicleRequest vehicleRequest) {
        return "Adding new vehicle....";
    }
}
