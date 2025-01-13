package ch.blelo.jpapi.model.entity.jmnedict;

import ch.blelo.jpapi.model.entity.common.Base;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(name = "jmned_trans")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class JMNEDictTranslation extends Base {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "entry_id", nullable = false)
    public JMNEDictEntry entry;

    @ElementCollection
    @CollectionTable(name = "jmned_trans_type", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "trans_type")
    public Set<String> nameTypes;

    @OneToMany(mappedBy = "translation")
    public Set<JMNEDictTranslationDetail> details;
}
