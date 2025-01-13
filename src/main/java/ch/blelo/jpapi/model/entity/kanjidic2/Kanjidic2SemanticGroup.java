package ch.blelo.jpapi.model.entity.kanjidic2;

import ch.blelo.jpapi.model.entity.common.Base;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(name = "kd2_semgroup")
@NoArgsConstructor
@SuperBuilder
public class Kanjidic2SemanticGroup extends Base {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "character_id")
    public Kanjidic2Character character;

    @OneToMany(mappedBy = "semanticGroup")
    public Set<Kanjidic2Reading> readings;

    @OneToMany(mappedBy = "semanticGroup")
    public Set<Kanjidic2Meaning> meanings;
}
