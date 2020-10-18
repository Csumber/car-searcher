package hu.bme.vik.ambrustorok.vehicleservice.repository;

import hu.bme.vik.ambrustorok.vehicleservice.model.Engine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EngineRepository extends MongoRepository<Engine, String> {
}
