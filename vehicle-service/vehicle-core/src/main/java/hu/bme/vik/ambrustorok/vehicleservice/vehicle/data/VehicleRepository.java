package hu.bme.vik.ambrustorok.vehicleservice.vehicle.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface VehicleRepository extends JpaRepository<VehicleEntity, UUID> {

    @Query(value = "select v from VehicleEntity v join fetch v.engines join fetch v.options ")
    List<VehicleEntity> fetchAllWithJoins();
}
