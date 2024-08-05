package ch.blelo.kanjiguide.model.entity.kanjidic2;

import ch.blelo.kanjiguide.model.entity.base.Base;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "kd2_meaning")
@NoArgsConstructor
@SuperBuilder
public class Meaning extends Base {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rmgroup_id")
    public SemanticGroup semanticGroup;

    @Column(name = "lang")
    public String languageCode;

    @Column(name = "element")
    public String element;
}
