package hu.bme.vik.ambrustorok.vehicleservice.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionRegisterDTO {

    private String name;

    private String value;

    private double price;
}
