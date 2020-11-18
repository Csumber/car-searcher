package hu.bme.vik.ambrustorok.vehicleservice.engine.data;

import hu.bme.vik.ambrustorok.vehicleservice.common.EFuel;
import hu.bme.vik.ambrustorok.vehicleservice.common.ETransmission;
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
public class EngineEntity {

    @ManyToMany(mappedBy = "engines")
    Set<VehicleEntity> vehicles;
    @Id
    private UUID id = UUID.randomUUID();
    @Column(nullable = false)
    private double consumption;
    @Column(nullable = false)
    private int cylinderCapacity;
    @Column(nullable = false)
    private EFuel fuel;
    @Column(nullable = false)
    private ETransmission transmission;
    @Column(nullable = false)
    private int horsepower;
    @Column(nullable = false)
    private double price;
}
