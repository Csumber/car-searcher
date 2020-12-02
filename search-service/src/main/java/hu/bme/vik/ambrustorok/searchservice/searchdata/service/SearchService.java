package hu.bme.vik.ambrustorok.searchservice.searchdata.service;

import hu.bme.vik.ambrustorok.searchservice.searchdata.data.SearchEntity;
import hu.bme.vik.ambrustorok.searchservice.searchdata.data.SearchRepository;
import hu.bme.vik.ambrustorok.searchservice.searchdata.dto.SearchRequest;
import hu.bme.vik.ambrustorok.vehicleservice.dto.engine.EngineServiceClient;
import hu.bme.vik.ambrustorok.vehicleservice.dto.option.OptionServiceClient;
import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleResponse;
import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleServiceClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
public class SearchService {

    private final SearchRepository repository;
    private final EngineServiceClient engineServiceClient;
    private final OptionServiceClient optionServiceClient;
    private final VehicleServiceClient vehicleServiceClient;

    public Collection<SearchEntity> findAll() {
        return repository.findAll();
    }

    public Optional<SearchEntity> findOne(UUID id) {
        return repository.findById(id);
    }

    public SearchEntity create(SearchRequest dto) {
        SearchEntity entity = new SearchEntity();

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

    public Collection<SearchEntity> findByUsername(String username) {
        return repository.findAllByUsername(username);
    }

    public Collection<VehicleResponse> search(SearchRequest search) {
        List<Collection<VehicleResponse>> results = new ArrayList<>();
        Collection<VehicleResponse> finalResults;

        for (var v : search.getOptions()) {
            results.add(vehicleServiceClient.findAllByOption(v.getId()).getBody());
        }
        for (var v : search.getEngines()) {
            results.add(vehicleServiceClient.findAllbyEngine(v.getId()).getBody());
        }

        if (results.isEmpty())
            return Collections.emptyList();

        if (results.size() == 1)
            return results.get(0);

        finalResults = results.get(0);
        for (int i = 1; i < results.size(); i++) {
            finalResults.retainAll(results.get(i));
        }

        return finalResults;
    }
}
