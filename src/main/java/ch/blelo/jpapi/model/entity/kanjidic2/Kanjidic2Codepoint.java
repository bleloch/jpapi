package ch.blelo.jpapi.model.entity.kanjidic2;

import ch.blelo.jpapi.model.entity.common.WithTypeAndElement;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "kd2_codepoint")
@NoArgsConstructor
@SuperBuilder
public class Kanjidic2Codepoint extends WithTypeAndElement {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "character_id")
    public Kanjidic2Character character;
}