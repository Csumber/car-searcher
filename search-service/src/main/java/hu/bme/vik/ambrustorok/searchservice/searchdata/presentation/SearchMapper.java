package hu.bme.vik.ambrustorok.searchservice.searchdata.presentation;

import hu.bme.vik.ambrustorok.searchservice.searchdata.data.SearchEntity;
import hu.bme.vik.ambrustorok.searchservice.searchdata.dto.SearchResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SearchMapper {
    SearchResponse EntityToDTO(SearchEntity entity);
}
