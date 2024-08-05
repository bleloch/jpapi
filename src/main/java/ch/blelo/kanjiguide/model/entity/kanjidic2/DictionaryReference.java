package ch.blelo.kanjiguide.model.entity.kanjidic2;

import ch.blelo.kanjiguide.model.entity.base.WithTypeAndElementBase;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "kd2_dic_ref")
@NoArgsConstructor
@SuperBuilder
public class DictionaryReference extends WithTypeAndElementBase {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "character_id")
    public Character character;

    @Column(name = "m_vol")
    public int morohashiVolume;

    @Column(name = "m_page")
    public int morohashiPage;
}
