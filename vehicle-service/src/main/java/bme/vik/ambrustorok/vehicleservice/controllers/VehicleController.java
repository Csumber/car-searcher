package bme.vik.ambrustorok.vehicleservice.controllers;

import bme.vik.ambrustorok.vehicleservice.model.Engine;
import bme.vik.ambrustorok.vehicleservice.repository.EngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    EngineRepository engineRepository;

    @GetMapping("/admin")
    public String admin() {
        return "Hello Admin!";
    }

    @GetMapping("/user")
    public String user() {
        return "Hello User!";
    }

    @GetMapping("/guest")
    public String guest() {
        return "Hello Guest!";
    }

    @GetMapping("/vehicles")
    public List<Engine> vehicles() {
        return engineRepository.findAll();
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
