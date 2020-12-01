package hu.bme.vik.ambrustorok.vehicleservice.engine.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface EngineRepository extends JpaRepository<EngineEntity, UUID> {
    @Query("SELECT e FROM EngineEntity e left join e.vehicles where e.id = :id ")
    EngineEntity getEngineVehiclesById(@Param("id") UUID id);

    @Query("SELECT e FROM EngineEntity e left join fetch e.vehicles ")
//where o.id = :id ")
    List<EngineEntity> getEngineVehiclesById2(@Param("id") UUID id);

    @Query("select e from EngineEntity e left join e.vehicles ev left join ev.vehicleEntity evv where evv.id = :id")
    List<EngineEntity> getEngineEntityBy(@Param("id") UUID id);

}

