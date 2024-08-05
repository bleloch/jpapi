package ch.blelo.kanjiguide.model.entity.jmdict;

import ch.blelo.kanjiguide.model.entity.base.Base;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(name = "jmd_entry")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Entry extends Base {
    @Column(name = "ent_seq", unique = true, nullable = false)
    public long entrySequence;

    @OneToMany(mappedBy = "entry")
    public Set<Kanji> kanji;

    @OneToMany(mappedBy = "entry")
    public Set<JReading> readings;

    @OneToMany(mappedBy = "entry")
    public Set<Sense> senses;
}
