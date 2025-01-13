package ch.blelo.jpapi.model.entity.kanjidic2;

import ch.blelo.jpapi.model.entity.common.Base;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "kd2_meaning")
@NoArgsConstructor
@SuperBuilder
public class Kanjidic2Meaning extends Base {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "semgroup_id")
    public Kanjidic2SemanticGroup semanticGroup;

    @Column(name = "lang")
    public String languageCode;

    @Column(name = "element")
    public String element;
}
