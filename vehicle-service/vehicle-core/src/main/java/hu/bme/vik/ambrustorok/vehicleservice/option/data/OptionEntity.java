package hu.bme.vik.ambrustorok.vehicleservice.option.data;

import hu.bme.vik.ambrustorok.vehicleservice.vehicle.data.VehicleEntity;
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
public class OptionEntity {
    @Id
    private UUID id = UUID.randomUUID();

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String value;

    @Column(nullable = false)
    double price;

    @ManyToMany(mappedBy = "options")
    Set<VehicleEntity> vehicles;
}
