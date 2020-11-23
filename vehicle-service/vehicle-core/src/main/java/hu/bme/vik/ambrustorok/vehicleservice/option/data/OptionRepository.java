package hu.bme.vik.ambrustorok.vehicleservice.option.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OptionRepository extends JpaRepository<OptionEntity, UUID> {
}
