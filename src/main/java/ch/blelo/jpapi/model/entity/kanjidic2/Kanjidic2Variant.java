package ch.blelo.jpapi.model.entity.kanjidic2;

import ch.blelo.jpapi.model.entity.common.WithTypeAndElement;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "kd2_variant")
@NoArgsConstructor
@SuperBuilder
public class Kanjidic2Variant extends WithTypeAndElement {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "character_id")
    public Kanjidic2Character character;
}
