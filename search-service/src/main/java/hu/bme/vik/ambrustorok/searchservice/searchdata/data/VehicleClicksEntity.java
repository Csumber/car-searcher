package hu.bme.vik.ambrustorok.searchservice.searchdata.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
public class VehicleClicksEntity {
    @Id
    private UUID id = UUID.randomUUID();
    @Column(nullable = false)
    String username;
    @Column(nullable = false)
    UUID vehicleId;
    @Column(nullable = false)
    int clicks;

}
