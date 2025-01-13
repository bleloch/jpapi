package ch.blelo.jpapi.model.entity.jmnedict;

import ch.blelo.jpapi.model.entity.common.Base;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(name = "jmned_reading")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class JMNEDictReading extends Base {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "entry_id", nullable = false)
    public JMNEDictEntry entry;

    @Column(name = "element", nullable = false)
    public String element;

    @ElementCollection
    @CollectionTable(name = "jmned_reading_info", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "reading_info")
    public Set<String> readingInformation;

    @ElementCollection
    @CollectionTable(name = "jmned_reading_pri", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "reading_priority")
    public Set<String> priorityInformation;

    @ElementCollection
    @CollectionTable(name = "jmned_alt_reading", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "alt_reading")
    public Set<String> alternativeReadings;

    @OneToMany(mappedBy = "reading")
    public Set<JMNEDictReadingFurigana> furigana;
}
