package bme.vik.ambrustorok.vehicleservice.controllers;

import bme.vik.ambrustorok.vehicleservice.repository.EngineRepository;
import bme.vik.ambrustorok.vehicleservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    EngineRepository engineRepository;

    @Autowired
    VehicleRepository vehicleRepository;
}
