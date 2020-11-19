package hu.bme.vik.ambrustorok.vehicleservice.dto.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionResponseNoPrice {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String value;

}
