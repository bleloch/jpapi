package ch.blelo.kanjiguide.model.entity.kanjidic2;

import ch.blelo.kanjiguide.model.entity.base.Base;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(name = "kd2_character")
@NoArgsConstructor
@SuperBuilder
public class Character extends Base {
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

    @OneToMany(mappedBy = "character")
    public Set<Codepoint> codepoints;

    @OneToMany(mappedBy = "character")
    public Set<Radical> radicals;

    @ElementCollection
    @CollectionTable(name = "kd2_radnames", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "radnames")
    public Set<String> radicalNames;

    @OneToMany(mappedBy = "character")
    public Set<Variant> variants;

    @OneToMany(mappedBy = "character")
    public Set<DictionaryReference> dictionaryReferences;

    @OneToMany(mappedBy = "character")
    public Set<QueryCode> queryCodes;

    @OneToMany(mappedBy = "character")
    public Set<SemanticGroup> semanticGroups;

    @ElementCollection
    @CollectionTable(name = "kd2_nanori", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "nanori")
    public Set<String> nanori;
}
