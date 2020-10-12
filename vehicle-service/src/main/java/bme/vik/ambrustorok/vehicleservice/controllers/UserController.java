package bme.vik.ambrustorok.vehicleservice.controllers;

import bme.vik.ambrustorok.vehicleservice.model.Engine;
import bme.vik.ambrustorok.vehicleservice.model.Vehicle;
import bme.vik.ambrustorok.vehicleservice.repository.EngineRepository;
import bme.vik.ambrustorok.vehicleservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    EngineRepository engineRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @GetMapping("/vehicles")
    public List<Vehicle> vehicles() {
        return vehicleRepository.findAll();
    }

    @PostMapping("/vehicles")
    String newVehicle() {
        Engine engine = new Engine();
        engine.setFuel("asd");
        engine.setCylinder_capacity(666);
        engine.setPrice_from_base(0);
        engine.setHorsepower(420);
        engineRepository.save(engine);
        return engine.getId();

    }
}
