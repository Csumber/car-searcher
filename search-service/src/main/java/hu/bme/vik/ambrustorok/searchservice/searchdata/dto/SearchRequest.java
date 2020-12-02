package hu.bme.vik.ambrustorok.searchservice.searchdata.dto;

import hu.bme.vik.ambrustorok.vehicleservice.common.EStyle;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {

    private double lengthMin;
    private double lengthMax;
    private String manufacturer;
    private String model;
    private int numberOfDoorsMin;
    private int numberOfDoorsMax;
    private double priceMin;
    private double priceMax;
    private EStyle style;
    private String username;
    private int warrantyMin;
    private double weightMin;
    private double widthMin;
    private int warrantyMax;
    private double weightMax;
    private double widthMax;
}
