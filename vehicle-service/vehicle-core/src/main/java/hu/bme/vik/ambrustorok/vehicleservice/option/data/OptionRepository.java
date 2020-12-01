package hu.bme.vik.ambrustorok.vehicleservice.option.data;

import hu.bme.vik.ambrustorok.vehicleservice.vehicle.data.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface OptionRepository extends JpaRepository<OptionEntity, UUID> {

    @Query(value = "select distinct v from VehicleEntity v inner join fetch v.options ov join fetch ov.optionEntity where v.id = :id ")
    Optional<VehicleEntity> getOptionsByVehicle(@Param("id") UUID id);

}

