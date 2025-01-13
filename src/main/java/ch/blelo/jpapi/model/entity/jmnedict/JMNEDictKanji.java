package ch.blelo.jpapi.model.entity.jmnedict;

import ch.blelo.jpapi.model.entity.common.Base;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(
        name = "jmned_kanji",
        indexes = @Index(name = "idx_jmned_kanji_element", columnList = "element")
)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class JMNEDictKanji extends Base {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "entry_id", nullable = false)
    public JMNEDictEntry entry;

    @Column(name = "element", nullable = false)
    public String element;

    @ElementCollection
    @CollectionTable(name = "jmned_kanji_orth", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "kanji_orthography")
    public Set<String> orthographyInformation;

    @ElementCollection
    @CollectionTable(name = "jmned_kanji_pri", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "kanji_priority")
    public Set<String> priorityInformation;
}
