package ch.blelo.jpapi.model.entity.jmnedict;

import ch.blelo.jpapi.model.entity.common.Base;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "jmned_trans_detail")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class JMNEDictTranslationDetail extends Base {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trans_id", nullable = false)
    public JMNEDictTranslation translation;

    @Column(name = "trans_name")
    public String translatedName;

    @Column(name = "lang")
    public String languageCode;
}
