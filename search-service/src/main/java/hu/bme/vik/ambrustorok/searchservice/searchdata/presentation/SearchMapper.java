package hu.bme.vik.ambrustorok.searchservice.searchdata.presentation;

import hu.bme.vik.ambrustorok.searchservice.searchdata.data.EngineSearchEntity;
import hu.bme.vik.ambrustorok.searchservice.searchdata.data.OptionSearchEntity;
import hu.bme.vik.ambrustorok.searchservice.searchdata.data.SearchEntity;
import hu.bme.vik.ambrustorok.searchservice.searchdata.dto.SearchResponse;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface SearchMapper {

    static UUID OptionSearchEntityToUUID(OptionSearchEntity optionSearchEntity) {
        if (optionSearchEntity == null) {
            return null;

        }
        return optionSearchEntity.getOptionId();
    }

    static UUID EngineSearchEntityToUUID(EngineSearchEntity engineSearchEntity) {
        if (engineSearchEntity == null) {
            return null;

        }
        return engineSearchEntity.getEngineId();
    }

    SearchResponse EntityToDTO(SearchEntity entity);
}
