package ch.blelo.jpapi.model.mapper.kanjidic2;

import ch.blelo.jpapi.model.dto.common.KanjiDto;
import ch.blelo.jpapi.model.dto.common.ReadingDto;
import ch.blelo.jpapi.model.dto.jmdict.JMDictEntryDto;
import ch.blelo.jpapi.model.dto.jmdict.JMDictGlossDto;
import ch.blelo.jpapi.model.dto.jmdict.JMDictLoanwordSourceDto;
import ch.blelo.jpapi.model.dto.jmdict.JMDictSenseDto;
import ch.blelo.jpapi.model.dto.kanjidic2.Kanjidic2CharacterDto;
import ch.blelo.jpapi.model.entity.jmdict.*;
import ch.blelo.jpapi.model.entity.kanjidic2.Kanjidic2Character;
import org.mapstruct.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class Kanjidic2CharacterMapper {

    @Mapping(source = "metadata.frequency", target = "frequency")
    @Mapping(source = "metadata.schoolGrade", target = "schoolGrade")
    @Mapping(source = "metadata.jlptGrade", target = "jlptGrade")
    @Mapping(source = "metadata.strokeCount", target = "strokeCount")
    @Mapping(source = "metadata.variants", target = "variants")
    @Mapping(source = "metadata.radicalNames", target = "radicalNames")
    @Mapping(source = "semantics.semanticGroups", target = "semanticGroups")
    @Mapping(source = "semantics.nanori", target = "nanori")
    abstract Kanjidic2Character toEntity(Kanjidic2CharacterDto characterDto);

    @InheritInverseConfiguration(name = "toEntity")
    public abstract Kanjidic2CharacterDto toDto(Kanjidic2Character character);

    protected JMDictEntryDto entryToEntryDto(JMDictEntry entry) {
        if ( entry == null ) {
            return null;
        }

        JMDictEntryDto.JMDictEntryDtoBuilder entryDto = JMDictEntryDto.builder();

        entryDto.entrySequence( entry.entrySequence );
        entryDto.kanji( kanjiSetToKanjiDtoSet( entry.kanji ) );
        entryDto.readings( jReadingSetToReadingDtoSet( entry.readings ) );
        entryDto.senses( senseSetToSenseDtoSet( entry.senses ) );

        return entryDto.build();
    }

    protected Set<KanjiDto> kanjiSetToKanjiDtoSet(Set<JMDictKanji> set) {
        if ( set == null ) {
            return null;
        }

        Set<KanjiDto> set1 = new LinkedHashSet<KanjiDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( JMDictKanji kanji : set ) {
            set1.add( kanjiToKanjiDto( kanji ) );
        }

        return set1;
    }

    protected KanjiDto kanjiToKanjiDto(JMDictKanji kanji) {
        if ( kanji == null ) {
            return null;
        }

        KanjiDto.KanjiDtoBuilder kanjiDto = KanjiDto.builder();

        kanjiDto.element( kanji.element );
        Set<String> set = kanji.orthographyInformation;
        if ( set != null ) {
            kanjiDto.orthographyInformation( new LinkedHashSet<String>( set ) );
        }
        Set<String> set1 = kanji.priorityInformation;
        if ( set1 != null ) {
            kanjiDto.priorityInformation( new LinkedHashSet<String>( set1 ) );
        }

        return kanjiDto.build();
    }

    protected Set<ReadingDto> jReadingSetToReadingDtoSet(Set<JMDictReading> set) {
        if ( set == null ) {
            return null;
        }

        Set<ReadingDto> set1 = new LinkedHashSet<ReadingDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( JMDictReading jReading : set ) {
            set1.add( jReadingToReadingDto( jReading ) );
        }

        return set1;
    }

    protected ReadingDto jReadingToReadingDto(JMDictReading reading) {
        if ( reading == null ) {
            return null;
        }

        ReadingDto.ReadingDtoBuilder readingDto = ReadingDto.builder();

        readingDto.element( reading.element );
        readingDto.nokanji( reading.nokanji );
        Set<String> set = reading.readingInformation;
        if ( set != null ) {
            readingDto.readingInformation( new LinkedHashSet<String>( set ) );
        }
        Set<String> set1 = reading.priorityInformation;
        if ( set1 != null ) {
            readingDto.priorityInformation( new LinkedHashSet<String>( set1 ) );
        }
        Set<String> set2 = reading.alternativeReadings;
        if ( set2 != null ) {
            readingDto.alternativeReadings( new LinkedHashSet<String>( set2 ) );
        }

        return readingDto.build();
    }

    protected Set<JMDictSenseDto> senseSetToSenseDtoSet(Set<JMDictSense> set) {
        if ( set == null ) {
            return null;
        }

        Set<JMDictSenseDto> set1 = new LinkedHashSet<JMDictSenseDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( JMDictSense sense : set ) {
            set1.add( senseToSenseDto( sense ) );
        }

        return set1;
    }

    protected JMDictSenseDto senseToSenseDto(JMDictSense sense) {
        if ( sense == null ) {
            return null;
        }

        JMDictSenseDto.JMDictSenseDtoBuilder senseDto = JMDictSenseDto.builder();

        Set<String> set = sense.limitedToKanji;
        if ( set != null ) {
            senseDto.limitedToKanji( new LinkedHashSet<String>( set ) );
        }
        Set<String> set1 = sense.limitedToReadings;
        if ( set1 != null ) {
            senseDto.limitedToReadings( new LinkedHashSet<String>( set1 ) );
        }
        Set<String> set2 = sense.partOfSpeech;
        if ( set2 != null ) {
            senseDto.partOfSpeech( new LinkedHashSet<String>( set2 ) );
        }
        Set<String> set3 = sense.crossReferences;
        if ( set3 != null ) {
            senseDto.crossReferences( new LinkedHashSet<String>( set3 ) );
        }
        Set<String> set4 = sense.antonyms;
        if ( set4 != null ) {
            senseDto.antonyms( new LinkedHashSet<String>( set4 ) );
        }
        Set<String> set5 = sense.fieldsOfApplication;
        if ( set5 != null ) {
            senseDto.fieldsOfApplication( new LinkedHashSet<String>( set5 ) );
        }
        Set<String> set6 = sense.miscellaneousInformation;
        if ( set6 != null ) {
            senseDto.miscellaneousInformation( new LinkedHashSet<String>( set6 ) );
        }
        Set<String> set7 = sense.senseInformation;
        if ( set7 != null ) {
            senseDto.senseInformation( new LinkedHashSet<String>( set7 ) );
        }
        senseDto.loanwordSources( loanwordSourceSetToLoanwordSourceDtoSet( sense.loanwordSources ) );
        Set<String> set9 = sense.dialects;
        if ( set9 != null ) {
            senseDto.dialects( new LinkedHashSet<String>( set9 ) );
        }
        senseDto.glosses( glossSetToGlossDtoSet( sense.glosses ) );

        return senseDto.build();
    }

    protected Set<JMDictLoanwordSourceDto> loanwordSourceSetToLoanwordSourceDtoSet(Set<JMDictLoanwordSource> set) {
        if ( set == null ) {
            return null;
        }

        Set<JMDictLoanwordSourceDto> set1 = new LinkedHashSet<JMDictLoanwordSourceDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( JMDictLoanwordSource loanwordSource : set ) {
            set1.add( loanwordSourceToLoanwordSourceDto( loanwordSource ) );
        }

        return set1;
    }

    protected JMDictLoanwordSourceDto loanwordSourceToLoanwordSourceDto(JMDictLoanwordSource loanwordSource) {
        if ( loanwordSource == null ) {
            return null;
        }

        JMDictLoanwordSourceDto.JMDictLoanwordSourceDtoBuilder loanwordSourceDto = JMDictLoanwordSourceDto.builder();

        loanwordSourceDto.element( loanwordSource.element );
        loanwordSourceDto.languageCode( loanwordSource.languageCode );
        loanwordSourceDto.semanticCoverage( loanwordSource.semanticCoverage );
        loanwordSourceDto.isConstructedFromSourceLanguageWord( loanwordSource.isConstructedFromSourceLanguageWord );

        return loanwordSourceDto.build();
    }

    protected Set<JMDictGlossDto> glossSetToGlossDtoSet(Set<JMDictGloss> set) {
        if ( set == null ) {
            return null;
        }

        Set<JMDictGlossDto> set1 = new LinkedHashSet<JMDictGlossDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( JMDictGloss gloss : set ) {
            set1.add( glossToGlossDto( gloss ) );
        }

        return set1;
    }

    protected JMDictGlossDto glossToGlossDto(JMDictGloss gloss) {
        if ( gloss == null ) {
            return null;
        }

        JMDictGlossDto.JMDictGlossDtoBuilder glossDto = JMDictGlossDto.builder();

        glossDto.element( gloss.element );
        glossDto.languageCode( gloss.languageCode );
        glossDto.gender( gloss.gender );
        glossDto.semanticProperty( gloss.semanticProperty );

        return glossDto.build();
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract Kanjidic2Character partialUpdate(Kanjidic2CharacterDto characterDto, @MappingTarget Kanjidic2Character character);
}