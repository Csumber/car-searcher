package hu.bme.vik.ambrustorok.searchservice.searchdata.data;

import hu.bme.vik.ambrustorok.vehicleservice.common.EStyle;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class SearchEntity {

    @Id
    private UUID id = UUID.randomUUID();
    @Column(nullable = false)
    private double lengthMin;
    @Column(nullable = false)
    private double lengthMax;
    @Column(nullable = false)
    private String manufacturer;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private int numberOfDoorsMin;
    @Column(nullable = false)
    private int numberOfDoorsMax;
    @Column(nullable = false)
    private double priceMin;
    @Column(nullable = false)
    private double priceMax;
    @Column(nullable = false)
    private EStyle style;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private int warrantyMin;
    @Column(nullable = false)
    private double weightMin;
    @Column(nullable = false)
    private double widthMin;
    @Column(nullable = false)
    private int warrantyMax;
    @Column(nullable = false)
    private double weightMax;
    @Column(nullable = false)
    private double widthMax;
    @OneToMany(mappedBy = "search")
    private Set<OptionSearchEntity> options;
    @OneToMany(mappedBy = "search")
    private Set<EngineSearchEntity> engines;

}
