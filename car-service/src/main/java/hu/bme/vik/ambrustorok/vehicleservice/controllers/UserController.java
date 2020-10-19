package hu.bme.vik.ambrustorok.vehicleservice.controllers;

import hu.bme.vik.ambrustorok.vehicleservice.model.Option;
import hu.bme.vik.ambrustorok.vehicleservice.payload.request.SearchRequest;
import hu.bme.vik.ambrustorok.vehicleservice.payload.response.SearchResult;
import hu.bme.vik.ambrustorok.vehicleservice.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guest")
public class UserController {
    @Autowired
    VehicleService vehicleService;

    @GetMapping("/manufacturers")
    @ResponseBody
    public List<String> getAllManufacturers() {
        return vehicleService.getAllManufacturers();
    }

    @GetMapping("/manufacturers/{manufacturer}")
    @ResponseBody
    public List<String> getAllModelsOfManufacturer(@RequestParam String manufacturer) {
        return vehicleService.getAllModels(manufacturer);
    }

    @GetMapping("/manufacturers/{manufacturer}/{model}")
    @ResponseBody
    public List<Option> getAllModelsOfManufacturer(@RequestParam String manufacturer, @RequestParam String model) {
        return vehicleService.getAllFacets(manufacturer, model);
    }

    @PostMapping("/search")
    @ResponseBody
    public List<SearchResult> search(@RequestBody SearchRequest searchRequest) {
        //TODO save in searchDB
        return vehicleService.search(searchRequest);
    }
}
