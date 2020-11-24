package hu.bme.vik.ambrustorok.vehicleservice.option.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface OptionRepository extends JpaRepository<OptionEntity, UUID> {
    @Query("SELECT o FROM OptionEntity o left join o.vehicles where o.id = :id ")
    OptionEntity getOptionVehiclesById(@Param("id") UUID id);

    @Query("SELECT o FROM OptionEntity o left join fetch o.vehicles ")//where o.id = :id ")
    List<OptionEntity> getOptionVehiclesById2(@Param("id") UUID id);

    @Query("select o from OptionEntity o left join o.vehicles ov left join ov.vehicleEntity ovv where ovv.id = :id")
    List<OptionEntity> getOptionEntityBy(@Param("id") UUID id);

}
