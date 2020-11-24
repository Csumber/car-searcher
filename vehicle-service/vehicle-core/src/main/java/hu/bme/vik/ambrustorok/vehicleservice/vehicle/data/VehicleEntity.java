package hu.bme.vik.ambrustorok.vehicleservice.vehicle.data;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import hu.bme.vik.ambrustorok.vehicleservice.common.EStyle;
import hu.bme.vik.ambrustorok.vehicleservice.connector.OptionVehicleEntity;
import hu.bme.vik.ambrustorok.vehicleservice.engine.data.EngineEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class VehicleEntity {

    @ManyToMany
    @JsonManagedReference
    List<EngineEntity> engines;
    @JsonManagedReference
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "vehicleEntity",
            cascade = CascadeType.REFRESH
    )
    List<OptionVehicleEntity> options = new ArrayList<>();
    @Id
    private UUID id = UUID.randomUUID();
    @Column(nullable = false)
    private double price;
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
}
