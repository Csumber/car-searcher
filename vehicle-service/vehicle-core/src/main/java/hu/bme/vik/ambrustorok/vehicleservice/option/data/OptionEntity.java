package hu.bme.vik.ambrustorok.vehicleservice.option.data;

import hu.bme.vik.ambrustorok.vehicleservice.connector.OptionVehicleEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class OptionEntity {
    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "optionEntity",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<OptionVehicleEntity> vehicles = new ArrayList<>();
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String value;
    @Id
    private UUID id = UUID.randomUUID();

//    @Transactional
//    public void addVehicle(VehicleEntity vehicleEntity, double price) {
//        OptionVehicleEntity optionVehicleEntity = new OptionVehicleEntity(this, vehicleEntity);
//        optionVehicleEntity.setPrice(price);
//        vehicles.add(optionVehicleEntity);
//        vehicleEntity.getOptions().add(optionVehicleEntity);
//    }
//
//    public void removeVehicle(VehicleEntity vehicleEntity) {
//        for (Iterator<OptionVehicleEntity> iterator = vehicles.iterator();
//             iterator.hasNext(); ) {
//            OptionVehicleEntity optionVehicleEntity = iterator.next();
//
//            if (optionVehicleEntity.getOptionEntity().equals(this) &&
//                    optionVehicleEntity.getVehicleEntity().equals(vehicleEntity)) {
//                iterator.remove();
//                optionVehicleEntity.getVehicleEntity().getOptions().remove(optionVehicleEntity);
//                optionVehicleEntity.setOptionEntity(null);
//                optionVehicleEntity.setVehicleEntity(null);
//            }
//        }
//    }
}
