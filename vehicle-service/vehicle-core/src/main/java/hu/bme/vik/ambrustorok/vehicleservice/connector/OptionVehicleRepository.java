package hu.bme.vik.ambrustorok.vehicleservice.connector;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionVehicleRepository extends JpaRepository<OptionVehicleEntity, OptionVehicleId> {
}
