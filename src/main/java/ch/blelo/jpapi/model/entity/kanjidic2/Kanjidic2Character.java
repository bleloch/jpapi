package ch.blelo.jpapi.model.entity.kanjidic2;

import ch.blelo.jpapi.model.entity.common.Base;
import ch.blelo.jpapi.model.entity.jmdict.JMDictEntry;
import ch.blelo.jpapi.model.entity.jmnedict.JMNEDictEntry;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(name = "kd2_character")
@NoArgsConstructor
@SuperBuilder
public class Kanjidic2Character extends Base {
    @Column(name = "literal", unique = true, nullable = false)
    public String literal;

    @Column(name = "frequency")
    public int frequency;

    @Column(name = "school_grade")
    public int schoolGrade;

    @Column(name = "jlpt_grade")
    public int jlptGrade;

    @Column(name = "stroke_count", nullable = false)
    public int strokeCount;

    @ElementCollection
    @CollectionTable(name = "kd2_radnames", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "radnames")
    public Set<String> radicalNames;

    @ElementCollection
    @CollectionTable(name = "kd2_nanori", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "nanori")
    public Set<String> nanori;

    @OneToMany(mappedBy = "character")
    public Set<Kanjidic2Codepoint> codepoints;

    @OneToMany(mappedBy = "character")
    public Set<Kanjidic2Radical> radicals;

    @OneToMany(mappedBy = "character")
    public Set<Kanjidic2Variant> variants;

    @OneToMany(mappedBy = "character")
    public Set<Kanjidic2DictionaryReference> dictionaryReferences;

    @OneToMany(mappedBy = "character")
    public Set<Kanjidic2QueryCode> queryCodes;

    @OneToMany(mappedBy = "character")
    public Set<Kanjidic2SemanticGroup> semanticGroups;

    @ManyToMany(mappedBy = "linkedCharacters", fetch = FetchType.LAZY)
    public Set<JMDictEntry> words;

    @ManyToMany(mappedBy = "linkedCharacters", fetch = FetchType.LAZY)
    public Set<JMNEDictEntry> names;
}
