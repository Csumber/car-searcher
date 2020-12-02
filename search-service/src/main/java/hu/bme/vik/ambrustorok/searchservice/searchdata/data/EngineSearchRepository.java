package hu.bme.vik.ambrustorok.searchservice.searchdata.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EngineSearchRepository extends JpaRepository<EngineSearchEntity, UUID> {
}
