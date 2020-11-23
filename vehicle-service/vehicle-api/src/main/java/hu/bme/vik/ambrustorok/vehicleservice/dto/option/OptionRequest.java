package hu.bme.vik.ambrustorok.vehicleservice.dto.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionRequest {

    private String name;

    private String value;
}
