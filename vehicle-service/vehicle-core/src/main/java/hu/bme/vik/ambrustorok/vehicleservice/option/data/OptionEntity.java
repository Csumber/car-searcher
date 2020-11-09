package hu.bme.vik.ambrustorok.vehicleservice.option.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    int price;
}
