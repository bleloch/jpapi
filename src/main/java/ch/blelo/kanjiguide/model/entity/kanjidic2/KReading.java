package ch.blelo.kanjiguide.model.entity.kanjidic2;

import ch.blelo.kanjiguide.model.entity.base.WithTypeAndElementBase;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "kd2_reading")
@NoArgsConstructor
@SuperBuilder
public class KReading extends WithTypeAndElementBase {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rmgroup_id")
    public SemanticGroup semanticGroup;

    @Column(name = "on_type")
    public String onType;

    @Column(name = "r_status")
    public String rStatus;
}
