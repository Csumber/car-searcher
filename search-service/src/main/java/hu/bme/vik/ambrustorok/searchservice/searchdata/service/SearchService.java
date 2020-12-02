package hu.bme.vik.ambrustorok.searchservice.searchdata.service;

import hu.bme.vik.ambrustorok.searchservice.searchdata.data.SearchEntity;
import hu.bme.vik.ambrustorok.searchservice.searchdata.data.SearchRepository;
import hu.bme.vik.ambrustorok.searchservice.searchdata.dto.SearchRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class SearchService {

    private SearchRepository repository;

    public List<SearchEntity> findAll() {
        return repository.findAll();
    }

    public Optional<SearchEntity> findOne(UUID id) {
        return repository.findById(id);
    }

    public SearchEntity create(SearchRequest dto) {
        log.debug("Creating new Search {}", dto);

        SearchEntity entity = new SearchEntity();
        entity.setTestString(dto.getTestString());
        entity.setUsername(dto.getUsername());

        return repository.save(entity);
    }

    public SearchEntity update(UUID id, SearchRequest dto) {
        SearchEntity entity = repository.getOne(id);

        entity.setLengthMax(dto.getLengthMax());
        entity.setLengthMin(dto.getLengthMin());
        entity.setManufacturer(dto.getManufacturer());
        entity.setModel(dto.getModel());
        entity.setNumberOfDoorsMax(dto.getNumberOfDoorsMax());
        entity.setNumberOfDoorsMin(dto.getNumberOfDoorsMin());
        entity.setPriceMax(dto.getPriceMax());
        entity.setPriceMin(dto.getPriceMin());
        entity.setStyle(dto.getStyle());
        entity.setUsername(dto.getUsername());
        entity.setWarrantyMax(dto.getWarrantyMax());
        entity.setWarrantyMin(dto.getWarrantyMin());
        entity.setWeightMax(dto.getWeightMax());
        entity.setWeightMin(dto.getWeightMin());
        entity.setWidthMax(dto.getWidthMax());
        entity.setWidthMin(dto.getWidthMin());


        return repository.save(entity);

    }

    public boolean delete(UUID id) {
        boolean exists = repository.existsById(id);
        if (exists) {
            repository.deleteById(id);
        }
        return exists;
    }
}
