package hu.bme.vik.ambrustorok.vehicleservice.controllers;

import hu.bme.vik.ambrustorok.vehicleservice.model.Engine;
import hu.bme.vik.ambrustorok.vehicleservice.payload.request.VehicleRequest;
import hu.bme.vik.ambrustorok.vehicleservice.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    VehicleService vehicleService;

    @GetMapping("/vehicles")
    public List<String> getAllVehicles() {
        return vehicleService.getAllManufacturers();
    }

    @PostMapping("/vehicles")
    public String addNewVehicle(@Valid @RequestBody VehicleRequest vehicleRequest) {
        return "Adding new vehicle....";
    }

    @PostMapping("/vehiclesss")
    String newVehicle() {
        Engine engine = new Engine();
        engine.setFuel("asd");
        engine.setCylinder_capacity(666);
        engine.setPrice_from_base(0);
        engine.setHorsepower(420);
        vehicleService.saveOrUpdate(null);
        return engine.getId();

    }
}
