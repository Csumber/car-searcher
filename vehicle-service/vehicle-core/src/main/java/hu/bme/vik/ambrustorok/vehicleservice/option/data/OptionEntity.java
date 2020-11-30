package hu.bme.vik.ambrustorok.vehicleservice.option.data;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import hu.bme.vik.ambrustorok.vehicleservice.option.connector.OptionVehicleEntity;
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
    @JsonManagedReference
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "optionEntity",
            cascade = CascadeType.REFRESH
    )
    List<OptionVehicleEntity> vehicles = new ArrayList<>();
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String value;
    @Id
    private UUID id = UUID.randomUUID();
}
