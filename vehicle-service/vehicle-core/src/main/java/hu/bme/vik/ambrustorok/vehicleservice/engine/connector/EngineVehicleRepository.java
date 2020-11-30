package hu.bme.vik.ambrustorok.vehicleservice.engine.connector;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineVehicleRepository extends JpaRepository<EngineVehicleEntity, EngineVehicleId> {
}
