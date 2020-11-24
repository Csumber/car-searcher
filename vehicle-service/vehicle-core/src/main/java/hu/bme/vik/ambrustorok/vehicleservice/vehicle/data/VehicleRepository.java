package hu.bme.vik.ambrustorok.vehicleservice.vehicle.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface VehicleRepository extends JpaRepository<VehicleEntity, UUID> {

    @Query(value = "select distinct v from VehicleEntity v inner join fetch v.options ov join fetch ov.optionEntity ")
    Collection<VehicleEntity> findAllWithOptions();

    @Query(value = "select distinct v from VehicleEntity v inner join fetch v.options ov join fetch ov.optionEntity where v.id = :id ")
    Optional<VehicleEntity> findOneWithOptions(@Param("id") UUID id);

    @Query(value = "select distinct v.manufacturer from VehicleEntity v ")
    Collection<String> findAllManufacturers();

    @Query(value = "select distinct v.model from VehicleEntity v WHERE LOWER(v.manufacturer) = LOWER(:manufacturer) ")
    Collection<String> findAllModelsByManufacturer(@Param("manufacturer") String manufacturer);

}
