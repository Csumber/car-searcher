package hu.bme.vik.ambrustorok.vehicleservice.engine.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EngineRepository extends JpaRepository<EngineEntity, UUID> {
}
