package ch.blelo.kanjiguide.model.mapper.kanjidic2;

import ch.blelo.kanjiguide.model.dto.jmdict.*;
import ch.blelo.kanjiguide.model.dto.kanjidic2.CharacterDto;
import ch.blelo.kanjiguide.model.entity.jmdict.*;
import ch.blelo.kanjiguide.model.entity.kanjidic2.Character;
import org.mapstruct.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CharacterMapper {

    @Mapping(source = "metadata.frequency", target = "frequency")
    @Mapping(source = "metadata.schoolGrade", target = "schoolGrade")
    @Mapping(source = "metadata.jlptGrade", target = "jlptGrade")
    @Mapping(source = "metadata.strokeCount", target = "strokeCount")
    @Mapping(source = "metadata.variants", target = "variants")
    @Mapping(source = "metadata.radicalNames", target = "radicalNames")
    @Mapping(source = "semantics.semanticGroups", target = "semanticGroups")
    @Mapping(source = "semantics.nanori", target = "nanori")
    abstract Character toEntity(CharacterDto characterDto);

    @InheritInverseConfiguration(name = "toEntity")
    public abstract CharacterDto toDto(Character character);

    protected EntryDto entryToEntryDto(Entry entry) {
        if ( entry == null ) {
            return null;
        }

        EntryDto.EntryDtoBuilder entryDto = EntryDto.builder();

        entryDto.entrySequence( entry.entrySequence );
        entryDto.kanji( kanjiSetToKanjiDtoSet( entry.kanji ) );
        entryDto.readings( jReadingSetToReadingDtoSet( entry.readings ) );
        entryDto.senses( senseSetToSenseDtoSet( entry.senses ) );

        return entryDto.build();
    }

    protected Set<KanjiDto> kanjiSetToKanjiDtoSet(Set<Kanji> set) {
        if ( set == null ) {
            return null;
        }

        Set<KanjiDto> set1 = new LinkedHashSet<KanjiDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Kanji kanji : set ) {
            set1.add( kanjiToKanjiDto( kanji ) );
        }

        return set1;
    }

    protected KanjiDto kanjiToKanjiDto(Kanji kanji) {
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

    protected Set<ch.blelo.kanjiguide.model.dto.jmdict.ReadingDto> jReadingSetToReadingDtoSet(Set<JReading> set) {
        if ( set == null ) {
            return null;
        }

        Set<ch.blelo.kanjiguide.model.dto.jmdict.ReadingDto> set1 = new LinkedHashSet<ch.blelo.kanjiguide.model.dto.jmdict.ReadingDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( JReading jReading : set ) {
            set1.add( jReadingToReadingDto( jReading ) );
        }

        return set1;
    }

    protected ch.blelo.kanjiguide.model.dto.jmdict.ReadingDto jReadingToReadingDto(JReading jReading) {
        if ( jReading == null ) {
            return null;
        }

        ch.blelo.kanjiguide.model.dto.jmdict.ReadingDto.ReadingDtoBuilder readingDto = ch.blelo.kanjiguide.model.dto.jmdict.ReadingDto.builder();

        readingDto.element( jReading.element );
        readingDto.nokanji( jReading.nokanji );
        Set<String> set = jReading.readingInformation;
        if ( set != null ) {
            readingDto.readingInformation( new LinkedHashSet<String>( set ) );
        }
        Set<String> set1 = jReading.priorityInformation;
        if ( set1 != null ) {
            readingDto.priorityInformation( new LinkedHashSet<String>( set1 ) );
        }
        Set<String> set2 = jReading.alternativeReadings;
        if ( set2 != null ) {
            readingDto.alternativeReadings( new LinkedHashSet<String>( set2 ) );
        }

        return readingDto.build();
    }

    protected Set<SenseDto> senseSetToSenseDtoSet(Set<Sense> set) {
        if ( set == null ) {
            return null;
        }

        Set<SenseDto> set1 = new LinkedHashSet<SenseDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Sense sense : set ) {
            set1.add( senseToSenseDto( sense ) );
        }

        return set1;
    }

    protected SenseDto senseToSenseDto(Sense sense) {
        if ( sense == null ) {
            return null;
        }

        SenseDto.SenseDtoBuilder senseDto = SenseDto.builder();

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

    protected Set<LoanwordSourceDto> loanwordSourceSetToLoanwordSourceDtoSet(Set<LoanwordSource> set) {
        if ( set == null ) {
            return null;
        }

        Set<LoanwordSourceDto> set1 = new LinkedHashSet<LoanwordSourceDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( LoanwordSource loanwordSource : set ) {
            set1.add( loanwordSourceToLoanwordSourceDto( loanwordSource ) );
        }

        return set1;
    }

    protected LoanwordSourceDto loanwordSourceToLoanwordSourceDto(LoanwordSource loanwordSource) {
        if ( loanwordSource == null ) {
            return null;
        }

        LoanwordSourceDto.LoanwordSourceDtoBuilder loanwordSourceDto = LoanwordSourceDto.builder();

        loanwordSourceDto.element( loanwordSource.element );
        loanwordSourceDto.languageCode( loanwordSource.languageCode );
        loanwordSourceDto.semanticCoverage( loanwordSource.semanticCoverage );
        loanwordSourceDto.isConstructedFromSourceLanguageWord( loanwordSource.isConstructedFromSourceLanguageWord );

        return loanwordSourceDto.build();
    }

    protected Set<GlossDto> glossSetToGlossDtoSet(Set<Gloss> set) {
        if ( set == null ) {
            return null;
        }

        Set<GlossDto> set1 = new LinkedHashSet<GlossDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Gloss gloss : set ) {
            set1.add( glossToGlossDto( gloss ) );
        }

        return set1;
    }

    protected GlossDto glossToGlossDto(Gloss gloss) {
        if ( gloss == null ) {
            return null;
        }

        GlossDto.GlossDtoBuilder glossDto = GlossDto.builder();

        glossDto.element( gloss.element );
        glossDto.languageCode( gloss.languageCode );
        glossDto.gender( gloss.gender );
        glossDto.semanticProperty( gloss.semanticProperty );

        return glossDto.build();
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract Character partialUpdate(CharacterDto characterDto, @MappingTarget Character character);
}