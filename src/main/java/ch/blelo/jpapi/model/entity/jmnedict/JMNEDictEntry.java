package ch.blelo.jpapi.model.entity.jmnedict;

import ch.blelo.jpapi.model.entity.common.Base;
import ch.blelo.jpapi.model.entity.kanjidic2.Kanjidic2Character;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(name = "jmned_entry")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class JMNEDictEntry extends Base {
    @OneToMany(mappedBy = "entry")
    public Set<JMNEDictKanji> kanji;

    @OneToMany(mappedBy = "entry")
    public Set<JMNEDictReading> readings;

    @OneToMany(mappedBy = "entry")
    public Set<JMNEDictTranslation> translations;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "jmned_kd2_assoc_char",
            joinColumns = @JoinColumn(name = "jmned_entry_id"),
            inverseJoinColumns = @JoinColumn(name = "kd2_character_id")
    )
    public Set<Kanjidic2Character> linkedCharacters;
}
