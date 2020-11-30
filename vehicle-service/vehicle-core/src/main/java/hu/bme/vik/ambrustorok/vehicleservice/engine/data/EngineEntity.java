package hu.bme.vik.ambrustorok.vehicleservice.engine.data;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import hu.bme.vik.ambrustorok.vehicleservice.common.EFuel;
import hu.bme.vik.ambrustorok.vehicleservice.common.ETransmission;
import hu.bme.vik.ambrustorok.vehicleservice.engine.connector.EngineVehicleEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class EngineEntity {
    @JsonManagedReference
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "engineEntity",
            cascade = CascadeType.REFRESH
    )
    List<EngineVehicleEntity> vehicles = new ArrayList<>();
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
}
