package ch.blelo.jpapi.model.entity.jmdict;

import ch.blelo.jpapi.model.entity.common.Base;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(
        name = "jmd_reading",
        indexes = @Index(name = "idx_jmd_reading_element", columnList = "element")
)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class JMDictReading extends Base {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "entry_id", nullable = false)
    public JMDictEntry entry;

    @Column(name = "element", nullable = false)
    public String element;

    @Column(name = "nokanji")
    public boolean nokanji;

    @ElementCollection
    @CollectionTable(name = "jmd_reading_info", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "reading_info")
    public Set<String> readingInformation;

    @ElementCollection
    @CollectionTable(name = "jmd_reading_pri", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "reading_priority")
    public Set<String> priorityInformation;

    @ElementCollection
    @CollectionTable(name = "jmd_alt_reading", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "alt_reading")
    public Set<String> alternativeReadings;

    @OneToMany(mappedBy = "reading")
    public Set<JMDictReadingFurigana> furigana;
}
