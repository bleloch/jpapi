package ch.blelo.jpapi.model.entity.jmdict;

import ch.blelo.jpapi.model.entity.common.Base;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "jmd_lsource")
@NoArgsConstructor
@SuperBuilder
public class JMDictLoanwordSource extends Base {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sense_id", nullable = false)
    public JMDictSense sense;

    @Column(name = "element", length = 1000)
    public String element;

    @Column(name = "lang")
    public String languageCode;

    @Column(name = "semantic_coverage")
    public String semanticCoverage;

    @Column(name = "from_source_lang_word")
    public boolean isConstructedFromSourceLanguageWord;
}
