package hu.bme.vik.ambrustorok.vehicleservice.vehicle.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VehicleRepository  extends JpaRepository<VehicleEntity, UUID> {
}
