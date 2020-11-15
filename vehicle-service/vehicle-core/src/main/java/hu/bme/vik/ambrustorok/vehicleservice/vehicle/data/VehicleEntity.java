package hu.bme.vik.ambrustorok.vehicleservice.vehicle.data;

import hu.bme.vik.ambrustorok.vehicleservice.common.EStyle;
import hu.bme.vik.ambrustorok.vehicleservice.engine.data.EngineEntity;
import hu.bme.vik.ambrustorok.vehicleservice.option.data.OptionEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class VehicleEntity {

    @Id
    private UUID id = UUID.randomUUID();

    @Column(nullable = false)
    private double basePrice;

    @Column(nullable = false)
    private int numberOfDoors;

    @Column(nullable = false)
    private double length;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private EStyle style;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private double width;

    @Column(nullable = false)
    private int warranty;

    @ManyToMany
    Set<EngineEntity> engines;

    @ManyToMany
    Set<OptionEntity> options;

}
