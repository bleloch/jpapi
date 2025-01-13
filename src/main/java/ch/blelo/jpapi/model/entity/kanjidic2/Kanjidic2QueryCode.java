package ch.blelo.jpapi.model.entity.kanjidic2;

import ch.blelo.jpapi.model.entity.common.WithTypeAndElementBase;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "kd2_qcode")
@NoArgsConstructor
@SuperBuilder
public class Kanjidic2QueryCode extends WithTypeAndElementBase {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "character_id")
    public Kanjidic2Character character;

    @Column(name = "skip_misclass")
    public String skipMisclassification;

}
