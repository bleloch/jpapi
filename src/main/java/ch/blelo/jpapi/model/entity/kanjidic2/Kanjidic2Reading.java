package ch.blelo.jpapi.model.entity.kanjidic2;

import ch.blelo.jpapi.model.entity.common.WithTypeAndElement;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "kd2_reading")
@NoArgsConstructor
@SuperBuilder
public class Kanjidic2Reading extends WithTypeAndElement {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "semgroup_id")
    public Kanjidic2SemanticGroup semanticGroup;

    @Column(name = "on_type")
    public String onType;

    @Column(name = "r_status")
    public String rStatus;
}
