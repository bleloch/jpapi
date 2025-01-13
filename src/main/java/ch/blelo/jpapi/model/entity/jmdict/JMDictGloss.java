package ch.blelo.jpapi.model.entity.jmdict;

import ch.blelo.jpapi.model.entity.common.Base;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(
        name = "jmd_gloss",
        indexes = @Index(name = "idx_jmd_gloss_element", columnList = "element")
)
@NoArgsConstructor
@SuperBuilder
public class JMDictGloss extends Base {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sense_id", nullable = false)
    public JMDictSense sense;

    @Column(name = "element", length = 1000)
    public String element;

    @Column(name = "lang")
    public String languageCode;

    @Column(name = "g_gend")
    public String gender;

    @Column(name = "g_type")
    public String semanticProperty;
}
