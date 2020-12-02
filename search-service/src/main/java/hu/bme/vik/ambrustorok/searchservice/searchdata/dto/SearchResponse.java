package hu.bme.vik.ambrustorok.searchservice.searchdata.dto;


import hu.bme.vik.ambrustorok.vehicleservice.dto.vehicle.VehicleResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResponse {

    @NotNull
    private UUID id;
    @NotNull
    @NotEmpty
    private String username;
    @NotNull
    @NotEmpty
    private String testString;
    @NotNull
    @NotEmpty
    private Collection<VehicleResponse> vehicle;

}
