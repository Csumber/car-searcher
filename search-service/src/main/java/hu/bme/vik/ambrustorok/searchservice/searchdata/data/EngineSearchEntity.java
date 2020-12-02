package hu.bme.vik.ambrustorok.searchservice.searchdata.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
@Getter
@Setter
public class EngineSearchEntity {

    @Id
    private UUID id = UUID.randomUUID();
    @Column(nullable = false)
    private UUID engineId;
    @Column(nullable = false)
    @ManyToOne
    private SearchEntity search;

}
