package hu.bme.vik.ambrustorok.vehicleservice.option.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface OptionRepository extends JpaRepository<OptionEntity, UUID> {

    @Query(value = "select distinct o from OptionEntity o ")
    List<OptionEntity> findAllOptionsWithoutPrice();
}
