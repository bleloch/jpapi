package ch.blelo.kanjiguide.model.entity.jmdict;

import ch.blelo.kanjiguide.model.entity.base.Base;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "jmd_lsource")
@NoArgsConstructor
@SuperBuilder
public class LoanwordSource extends Base {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sense_id", nullable = false)
    public Sense sense;

    @Column(name = "element", length = 1000)
    public String element;

    @Column(name = "language")
    public String languageCode;

    @Column(name = "semantic_coverage")
    public String semanticCoverage;

    @Column(name = "from_source_language_word")
    public boolean isConstructedFromSourceLanguageWord;
}
