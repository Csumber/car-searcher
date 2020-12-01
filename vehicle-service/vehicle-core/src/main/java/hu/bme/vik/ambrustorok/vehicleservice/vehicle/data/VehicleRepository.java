package hu.bme.vik.ambrustorok.vehicleservice.vehicle.data;

import hu.bme.vik.ambrustorok.vehicleservice.common.EFuel;
import hu.bme.vik.ambrustorok.vehicleservice.common.ETransmission;
import hu.bme.vik.ambrustorok.vehicleservice.engine.data.EngineEntity;
import hu.bme.vik.ambrustorok.vehicleservice.option.data.OptionEntity;
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
    Optional<VehicleEntity> findOne(@Param("id") UUID id);

    @Query(value = "select o from OptionEntity o inner join fetch o.vehicles ov join fetch ov.vehicleEntity where o.id = :id ")
    Optional<OptionEntity> findAllByOption(@Param("id") UUID id);

    @Query(value = "select e from EngineEntity e inner join fetch e.vehicles ev join fetch ev.vehicleEntity where e.id = :id ")
    Optional<EngineEntity> findAllbyEngine(@Param("id") UUID id);

    @Query(value = "select distinct v.manufacturer from VehicleEntity v ")
    Collection<String> findAllManufacturers();

    @Query(value = "select distinct v.model from VehicleEntity v WHERE LOWER(v.manufacturer) = LOWER(:manufacturer) ")
    Collection<String> findAllModelsByManufacturer(@Param("manufacturer") String manufacturer);

    @Query(value = "SELECT e FROM EngineEntity e WHERE e.consumption = :consumption AND e.cylinderCapacity = :cylinderCapacity AND e.fuel = :fuel AND e.transmission = :transmission AND e.horsepower = :horsepower ")
    Optional<EngineEntity> checkEngineExistence(@Param("consumption") double consumption, @Param("cylinderCapacity") int cylinderCapacity, @Param("fuel") EFuel fuel, @Param("transmission") ETransmission transmission, @Param("horsepower") int horsepower);

    @Query(value = "SELECT o FROM OptionEntity o WHERE LOWER(o.name) = LOWER(:name) AND LOWER(o.value) = LOWER(:value) ")
    Optional<OptionEntity> checkOptionExistence(@Param("name") String name, @Param("value") String value);
}

