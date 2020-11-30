package hu.bme.vik.ambrustorok.vehicleservice.option.connector;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionVehicleRepository extends JpaRepository<OptionVehicleEntity, OptionVehicleId> {
}
