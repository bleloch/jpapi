package ch.blelo.jpapi.model.entity.jmdict;

import ch.blelo.jpapi.model.entity.common.Base;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(name = "jmd_sense")
@NoArgsConstructor
@SuperBuilder
public class JMDictSense extends Base {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "entry_id", nullable = false)
    public JMDictEntry entry;

    @ElementCollection
    @CollectionTable(name = "jmd_limit_kanji", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "limited_to_kanji")
    public Set<String> limitedToKanji;

    @ElementCollection
    @CollectionTable(name = "jmd_limit_read", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "limited_to_reading")
    public Set<String> limitedToReadings;

    @ElementCollection
    @CollectionTable(name = "jmd_pos", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "part_of_speech")
    public Set<String> partOfSpeech;

    @ElementCollection
    @CollectionTable(name = "jmd_cross_ref", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "cross_reference")
    public Set<String> crossReferences;

    @ElementCollection
    @CollectionTable(name = "jmd_antonym", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "antonym")
    public Set<String> antonyms;

    @ElementCollection
    @CollectionTable(name = "jmd_field_of_app", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "field_of_application")
    public Set<String> fieldsOfApplication;

    @ElementCollection
    @CollectionTable(name = "jmd_misc_info", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "misc_info")
    public Set<String> miscellaneousInformation;

    @ElementCollection
    @CollectionTable(name = "jmd_sense_info", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "sense_info")
    public Set<String> senseInformation;

    @ElementCollection
    @CollectionTable(name = "jmd_dialect", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "dialect")
    public Set<String> dialects;

    @OneToMany(mappedBy = "sense")
    public Set<JMDictGloss> glosses;

    @OneToMany(mappedBy = "sense")
    public Set<JMDictLoanwordSource> loanwordSources;
}
