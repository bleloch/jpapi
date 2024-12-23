package ch.blelo.kanjiguide.model.entity.jmdict;

import ch.blelo.kanjiguide.model.entity.base.Base;
import ch.blelo.kanjiguide.model.entity.kanjidic2.Character;
import jakarta.persistence.*;
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "jmd_kd2_assoc_char",
            joinColumns = @JoinColumn(name = "jmd_entry_id"),
            inverseJoinColumns = @JoinColumn(name = "kd2_character_id")
    )
    public Set<Character> linkedCharacters;
}
