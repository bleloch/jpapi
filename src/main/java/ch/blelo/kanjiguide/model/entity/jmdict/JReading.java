package ch.blelo.kanjiguide.model.entity.jmdict;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(
        name = "jmd_reading",
        indexes = @Index(columnList = "element")
)
@NoArgsConstructor
@SuperBuilder
public class JReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "entry_id", nullable = false)
    public Entry entry;

    @Column(name = "element", nullable = false)
    public String element;

    @Column(name = "nokanji")
    public boolean nokanji;

    @ElementCollection
    @CollectionTable(name = "jmd_reading_info", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "reading_info")
    public Set<String> readingInformation;

    @ElementCollection
    @CollectionTable(name = "jmc_reading_pri", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "reading_priority")
    public Set<String> priorityInformation;

    @ElementCollection
    @CollectionTable(name = "jmd_alt_reading", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "alt_reading")
    public Set<String> alternativeReadings;
}
