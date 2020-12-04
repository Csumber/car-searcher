package hu.bme.vik.ambrustorok.searchservice.searchdata.service;

import hu.bme.vik.ambrustorok.searchservice.searchdata.data.*;
import hu.bme.vik.ambrustorok.searchservice.searchdata.dto.SearchRequest;
import hu.bme.vik.ambrustorok.vehicleservice.dto.engine.EngineServiceClient;
import hu.bme.vik.ambrustorok.vehicleservice.dto.option.OptionServiceClient;
import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleResponse;
import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleServiceClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.h2.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
public class SearchService {

    private final SearchRepository repository;
    private final EngineSearchRepository engineSearchRepository;
    private final OptionSearchRepository optionSearchRepository;

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


        Set<EngineSearchEntity> engines = new HashSet<>();
        Set<OptionSearchEntity> options = new HashSet<>();
        for (var v : dto.getOptions()) {
            options.add(new OptionSearchEntity(UUID.randomUUID(), v, entity));
        }
        for (var v : dto.getEngines()) {
            engines.add(new EngineSearchEntity(UUID.randomUUID(), v, entity));
        }

        entity.setEngines(engines);
        entity.setOptions(options);

        engineSearchRepository.saveAll(engines);
        optionSearchRepository.saveAll(options);
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
        Collection<VehicleResponse> finalResults;
        if (search.getOptions() == null && search.getEngines() == null ||
                search.getOptions().isEmpty() && search.getEngines().isEmpty())
            finalResults = vehicleServiceClient.findAll().getBody();
        else {
            List<Collection<VehicleResponse>> results = new ArrayList<>();

            if (search.getOptions() != null)
                for (var v : search.getOptions()) {
                    results.add(vehicleServiceClient.findAllByOption(v).getBody());
                }
            if (search.getEngines() != null)
                for (var v : search.getEngines()) {
                    results.add(vehicleServiceClient.findAllbyEngine(v).getBody());
                }

            if (results.isEmpty())
                return Collections.emptyList();

            finalResults = results.get(0);
            if (results.size() > 1) {
                for (int i = 1; i < results.size(); i++) {
                    finalResults.retainAll(results.get(i));
                }
            }
        }

        if (finalResults != null) {

            if (!StringUtils.isNullOrEmpty(search.getManufacturer()))
                finalResults.removeIf(v -> v.getManufacturer() != search.getManufacturer());
            if (!StringUtils.isNullOrEmpty(search.getModel()))
                finalResults.removeIf(v -> v.getModel() != search.getModel());
            if (search.getStyle() != null)
                finalResults.removeIf(v -> v.getStyle() != search.getStyle());
            if (search.getLengthMin() != 0)
                finalResults.removeIf(v -> v.getLength() < search.getLengthMin());
            if (search.getNumberOfDoorsMin() != 0)
                finalResults.removeIf(v -> v.getNumberOfDoors() < search.getNumberOfDoorsMin());
            if (search.getPriceMin() != 0)
                finalResults.removeIf(v -> v.getPrice() < search.getPriceMin());
            if (search.getWarrantyMin() != 0)
                finalResults.removeIf(v -> v.getWarranty() < search.getWarrantyMin());
            if (search.getWeightMin() != 0)
                finalResults.removeIf(v -> v.getWeight() < search.getWeightMin());
            if (search.getWidthMin() != 0)
                finalResults.removeIf(v -> v.getWidth() < search.getWidthMin());
            if (search.getLengthMax() != 0)
                finalResults.removeIf(v -> v.getLength() > search.getLengthMax());
            if (search.getNumberOfDoorsMax() != 0)
                finalResults.removeIf(v -> v.getNumberOfDoors() > search.getNumberOfDoorsMax());
            if (search.getPriceMax() != 0)
                finalResults.removeIf(v -> v.getPrice() > search.getPriceMax());
            if (search.getWarrantyMax() != 0)
                finalResults.removeIf(v -> v.getWarranty() > search.getWarrantyMax());
            if (search.getWeightMax() != 0)
                finalResults.removeIf(v -> v.getWeight() > search.getWeightMax());
            if (search.getWidthMin() != 0)
                finalResults.removeIf(v -> v.getWidth() > search.getWidthMin());
        }

        return finalResults;
    }
}
