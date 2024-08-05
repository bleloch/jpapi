package ch.blelo.kanjiguide.model.entity.jmdict;

import ch.blelo.kanjiguide.model.entity.base.Base;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(
        name = "jmd_kanji",
        indexes = @Index(columnList = "element")
)
@NoArgsConstructor
@SuperBuilder
public class Kanji extends Base {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "entry_id", nullable = false)
    public Entry entry;

    @Column(name = "element", nullable = false)
    public String element;

    @ElementCollection
    @CollectionTable(name = "jmd_kanji_orth", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "kanji_orthography")
    public Set<String> orthographyInformation;

    @ElementCollection
    @CollectionTable(name = "jmd_kanji_pri", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "kanji_priority")
    public Set<String> priorityInformation;
}
