package hu.bme.vik.ambrustorok.vehicleservice.vehicle.data;

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
    List<EngineEntity> engines;
    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "vehicleEntity",
            cascade = CascadeType.ALL,
            orphanRemoval = true
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

//    public void addOption(OptionEntity optionEntity, double price) {
//        OptionVehicleEntity optionVehicleEntity = new OptionVehicleEntity(optionEntity, this);
//        optionVehicleEntity.setPrice(price);
//        options.add(optionVehicleEntity);
//        optionEntity.getVehicles().add(optionVehicleEntity);
//    }
//
//    public void removeOption(OptionEntity optionEntity) {
//        for (Iterator<OptionVehicleEntity> iterator = options.iterator();
//             iterator.hasNext(); ) {
//            OptionVehicleEntity optionVehicleEntity = iterator.next();
//
//            if (optionVehicleEntity.getVehicleEntity().equals(this) &&
//                    optionVehicleEntity.getOptionEntity().equals(optionEntity)) {
//                iterator.remove();
//                optionVehicleEntity.getOptionEntity().getVehicles().remove(optionVehicleEntity);
//                optionVehicleEntity.setVehicleEntity(null);
//                optionVehicleEntity.setOptionEntity(null);
//            }
//        }
//    }
}
