package hu.bme.vik.ambrustorok.vehicleservice.vehicle.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.UUID;

public interface VehicleRepository extends JpaRepository<VehicleEntity, UUID> {

    @Query(value = "select v from VehicleEntity v join fetch v.options ov join fetch ov.optionEntity ")
    Collection<VehicleEntity> fetchWithOptions();

    @Query(value = "select distinct v.manufacturer from VehicleEntity v ")
    Collection<String> findManufacturers();

    @Query(value = "select distinct v.model from VehicleEntity v WHERE LOWER(v.manufacturer) = LOWER(:manufacturer) ")
    Collection<String> findModelsByManufacturer(@Param("manufacturer") String manufacturer);

//    @Query(value = "select distinct v.options from VehicleEntity v WHERE LOWER(v.manufacturer) = LOWER(:manufacturer) ")
//    Collection<OptionEntity> findOptionsByManufacturer(@Param("manufacturer") String manufacturer);

}
