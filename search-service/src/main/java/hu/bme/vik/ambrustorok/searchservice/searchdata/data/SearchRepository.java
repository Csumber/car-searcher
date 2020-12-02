package hu.bme.vik.ambrustorok.searchservice.searchdata.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.UUID;

public interface SearchRepository extends JpaRepository<SearchEntity, UUID> {
    Collection<SearchEntity> findAllByUsername(String username);
}
