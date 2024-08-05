package ch.blelo.kanjiguide.model.entity.kanjidic2;

import ch.blelo.kanjiguide.model.entity.base.Base;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(name = "kd2_rmgroup")
@NoArgsConstructor
@SuperBuilder
public class SemanticGroup extends Base {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "character_id")
    public Character character;

    @OneToMany(mappedBy = "semanticGroup")
    public Set<KReading> readings;

    @OneToMany(mappedBy = "semanticGroup")
    public Set<Meaning> meanings;
}
