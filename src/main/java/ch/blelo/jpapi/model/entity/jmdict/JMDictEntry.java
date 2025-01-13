package ch.blelo.jpapi.model.entity.jmdict;

import ch.blelo.jpapi.model.entity.common.Base;
import ch.blelo.jpapi.model.entity.kanjidic2.Kanjidic2Character;
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
public class JMDictEntry extends Base {
    @Column(name = "ent_seq", unique = true, nullable = false)
    public long entrySequence;

    @OneToMany(mappedBy = "entry")
    public Set<JMDictKanji> kanji;

    @OneToMany(mappedBy = "entry")
    public Set<JMDictReading> readings;

    @OneToMany(mappedBy = "entry")
    public Set<JMDictSense> senses;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "jmd_kd2_assoc_char",
            joinColumns = @JoinColumn(name = "jmd_entry_id"),
            inverseJoinColumns = @JoinColumn(name = "kd2_character_id")
    )
    public Set<Kanjidic2Character> linkedCharacters;
}
