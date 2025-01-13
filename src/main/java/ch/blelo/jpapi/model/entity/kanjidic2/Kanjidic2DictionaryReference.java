package ch.blelo.jpapi.model.entity.kanjidic2;

import ch.blelo.jpapi.model.entity.common.WithTypeAndElementBase;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "kd2_dic_ref")
@NoArgsConstructor
@SuperBuilder
public class Kanjidic2DictionaryReference extends WithTypeAndElementBase {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "character_id")
    public Kanjidic2Character character;

    @Column(name = "m_vol")
    public int morohashiVolume;

    @Column(name = "m_page")
    public int morohashiPage;
}
