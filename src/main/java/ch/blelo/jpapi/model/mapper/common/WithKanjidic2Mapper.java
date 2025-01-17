package ch.blelo.jpapi.model.mapper.common;

import ch.blelo.jpapi.model.dto.kanjidic2.*;
import ch.blelo.jpapi.model.entity.kanjidic2.*;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <p>Common mappings for Kanjidic2Character, where linked to by another data source (e.g. JMDict, JMNEDict).</p>
 * <p>Manually overrides generated MapStruct mappings that would otherwise cause cycles in the entity relationship.</p>
 * <p>Use when a data source links some context (e.g. a kanji representation) to kanji sourced by Kanjidic2 data.</p>
 */
public abstract class WithKanjidic2Mapper {
    protected Kanjidic2CharacterDto characterToCharacterDto(Kanjidic2Character character) {
        if ( character == null ) {
            return null;
        }

        Kanjidic2CharacterDto.Kanjidic2CharacterDtoBuilder characterDto = Kanjidic2CharacterDto.builder();

        characterDto.literal( character.literal );
        characterDto.codepoints( codepointSetToCodepointDtoSet( character.codepoints ) );
        characterDto.radicals( radicalSetToRadicalDtoSet( character.radicals ) );
        characterDto.dictionaryReferences( dictionaryReferenceSetToDictionaryReferenceDtoSet( character.dictionaryReferences ) );
        characterDto.queryCodes( queryCodeSetToQueryCodeDtoSet( character.queryCodes ) );

        return characterDto.build();
    }

    protected Kanjidic2CodepointDto codepointToCodepointDto(Kanjidic2Codepoint codepoint) {
        if ( codepoint == null ) {
            return null;
        }

        Kanjidic2CodepointDto.Kanjidic2CodepointDtoBuilder codepointDto = Kanjidic2CodepointDto.builder();

        codepointDto.element( codepoint.element );
        codepointDto.type( codepoint.type );

        return codepointDto.build();
    }

    protected Set<Kanjidic2CodepointDto> codepointSetToCodepointDtoSet(Set<Kanjidic2Codepoint> set) {
        if ( set == null ) {
            return null;
        }

        Set<Kanjidic2CodepointDto> set1 = new LinkedHashSet<Kanjidic2CodepointDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Kanjidic2Codepoint codepoint : set ) {
            set1.add( codepointToCodepointDto( codepoint ) );
        }

        return set1;
    }

    protected Kanjidic2RadicalDto radicalToRadicalDto(Kanjidic2Radical radical) {
        if ( radical == null ) {
            return null;
        }

        Kanjidic2RadicalDto.Kanjidic2RadicalDtoBuilder radicalDto = Kanjidic2RadicalDto.builder();

        radicalDto.element( radical.element );
        radicalDto.type( radical.type );

        return radicalDto.build();
    }

    protected Set<Kanjidic2RadicalDto> radicalSetToRadicalDtoSet(Set<Kanjidic2Radical> set) {
        if ( set == null ) {
            return null;
        }

        Set<Kanjidic2RadicalDto> set1 = new LinkedHashSet<Kanjidic2RadicalDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Kanjidic2Radical radical : set ) {
            set1.add( radicalToRadicalDto( radical ) );
        }

        return set1;
    }

    protected Kanjidic2DictionaryReferenceDto dictionaryReferenceToDictionaryReferenceDto(Kanjidic2DictionaryReference dictionaryReference) {
        if ( dictionaryReference == null ) {
            return null;
        }

        Kanjidic2DictionaryReferenceDto.Kanjidic2DictionaryReferenceDtoBuilder dictionaryReferenceDto = Kanjidic2DictionaryReferenceDto.builder();

        dictionaryReferenceDto.element( dictionaryReference.element );
        dictionaryReferenceDto.type( dictionaryReference.type );
        dictionaryReferenceDto.morohashiVolume( dictionaryReference.morohashiVolume );
        dictionaryReferenceDto.morohashiPage( dictionaryReference.morohashiPage );

        return dictionaryReferenceDto.build();
    }

    protected Set<Kanjidic2DictionaryReferenceDto> dictionaryReferenceSetToDictionaryReferenceDtoSet(Set<Kanjidic2DictionaryReference> set) {
        if ( set == null ) {
            return null;
        }

        Set<Kanjidic2DictionaryReferenceDto> set1 = new LinkedHashSet<Kanjidic2DictionaryReferenceDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Kanjidic2DictionaryReference dictionaryReference : set ) {
            set1.add( dictionaryReferenceToDictionaryReferenceDto( dictionaryReference ) );
        }

        return set1;
    }

    protected Kanjidic2QueryCodeDto queryCodeToQueryCodeDto(Kanjidic2QueryCode queryCode) {
        if ( queryCode == null ) {
            return null;
        }

        Kanjidic2QueryCodeDto.Kanjidic2QueryCodeDtoBuilder queryCodeDto = Kanjidic2QueryCodeDto.builder();

        queryCodeDto.element( queryCode.element );
        queryCodeDto.type( queryCode.type );
        queryCodeDto.skipMisclassification( queryCode.skipMisclassification );

        return queryCodeDto.build();
    }

    protected Set<Kanjidic2QueryCodeDto> queryCodeSetToQueryCodeDtoSet(Set<Kanjidic2QueryCode> set) {
        if ( set == null ) {
            return null;
        }

        Set<Kanjidic2QueryCodeDto> set1 = new LinkedHashSet<Kanjidic2QueryCodeDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Kanjidic2QueryCode queryCode : set ) {
            set1.add( queryCodeToQueryCodeDto( queryCode ) );
        }

        return set1;
    }
}
