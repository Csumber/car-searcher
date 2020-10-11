package bme.vik.ambrustorok.vehicleservice.repository;

import bme.vik.ambrustorok.vehicleservice.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {
}
