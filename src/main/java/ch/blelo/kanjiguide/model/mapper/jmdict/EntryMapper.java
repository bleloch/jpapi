package ch.blelo.kanjiguide.model.mapper.jmdict;

import ch.blelo.kanjiguide.model.dto.jmdict.EntryDto;
import ch.blelo.kanjiguide.model.dto.kanjidic2.*;
import ch.blelo.kanjiguide.model.entity.jmdict.Entry;
import ch.blelo.kanjiguide.model.entity.kanjidic2.*;
import ch.blelo.kanjiguide.model.entity.kanjidic2.Character;
import org.mapstruct.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class EntryMapper {
    abstract Entry toEntity(EntryDto entryDto);

    public abstract EntryDto toDto(Entry entry);

    protected CharacterDto characterToCharacterDto(Character character) {
        if ( character == null ) {
            return null;
        }

        CharacterDto.CharacterDtoBuilder characterDto = CharacterDto.builder();

        characterDto.literal( character.literal );
        characterDto.codepoints( codepointSetToCodepointDtoSet( character.codepoints ) );
        characterDto.radicals( radicalSetToRadicalDtoSet( character.radicals ) );
        characterDto.dictionaryReferences( dictionaryReferenceSetToDictionaryReferenceDtoSet( character.dictionaryReferences ) );
        characterDto.queryCodes( queryCodeSetToQueryCodeDtoSet( character.queryCodes ) );

        return characterDto.build();
    }

    protected CodepointDto codepointToCodepointDto(Codepoint codepoint) {
        if ( codepoint == null ) {
            return null;
        }

        CodepointDto.CodepointDtoBuilder codepointDto = CodepointDto.builder();

        codepointDto.element( codepoint.element );
        codepointDto.type( codepoint.type );

        return codepointDto.build();
    }

    protected Set<CodepointDto> codepointSetToCodepointDtoSet(Set<Codepoint> set) {
        if ( set == null ) {
            return null;
        }

        Set<CodepointDto> set1 = new LinkedHashSet<CodepointDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Codepoint codepoint : set ) {
            set1.add( codepointToCodepointDto( codepoint ) );
        }

        return set1;
    }

    protected RadicalDto radicalToRadicalDto(Radical radical) {
        if ( radical == null ) {
            return null;
        }

        RadicalDto.RadicalDtoBuilder radicalDto = RadicalDto.builder();

        radicalDto.element( radical.element );
        radicalDto.type( radical.type );

        return radicalDto.build();
    }

    protected Set<RadicalDto> radicalSetToRadicalDtoSet(Set<Radical> set) {
        if ( set == null ) {
            return null;
        }

        Set<RadicalDto> set1 = new LinkedHashSet<RadicalDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Radical radical : set ) {
            set1.add( radicalToRadicalDto( radical ) );
        }

        return set1;
    }

    protected DictionaryReferenceDto dictionaryReferenceToDictionaryReferenceDto(DictionaryReference dictionaryReference) {
        if ( dictionaryReference == null ) {
            return null;
        }

        DictionaryReferenceDto.DictionaryReferenceDtoBuilder dictionaryReferenceDto = DictionaryReferenceDto.builder();

        dictionaryReferenceDto.element( dictionaryReference.element );
        dictionaryReferenceDto.type( dictionaryReference.type );
        dictionaryReferenceDto.morohashiVolume( dictionaryReference.morohashiVolume );
        dictionaryReferenceDto.morohashiPage( dictionaryReference.morohashiPage );

        return dictionaryReferenceDto.build();
    }

    protected Set<DictionaryReferenceDto> dictionaryReferenceSetToDictionaryReferenceDtoSet(Set<DictionaryReference> set) {
        if ( set == null ) {
            return null;
        }

        Set<DictionaryReferenceDto> set1 = new LinkedHashSet<DictionaryReferenceDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( DictionaryReference dictionaryReference : set ) {
            set1.add( dictionaryReferenceToDictionaryReferenceDto( dictionaryReference ) );
        }

        return set1;
    }

    protected QueryCodeDto queryCodeToQueryCodeDto(QueryCode queryCode) {
        if ( queryCode == null ) {
            return null;
        }

        QueryCodeDto.QueryCodeDtoBuilder queryCodeDto = QueryCodeDto.builder();

        queryCodeDto.element( queryCode.element );
        queryCodeDto.type( queryCode.type );
        queryCodeDto.skipMisclassification( queryCode.skipMisclassification );

        return queryCodeDto.build();
    }

    protected Set<QueryCodeDto> queryCodeSetToQueryCodeDtoSet(Set<QueryCode> set) {
        if ( set == null ) {
            return null;
        }

        Set<QueryCodeDto> set1 = new LinkedHashSet<QueryCodeDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( QueryCode queryCode : set ) {
            set1.add( queryCodeToQueryCodeDto( queryCode ) );
        }

        return set1;
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract Entry partialUpdate(EntryDto entryDto, @MappingTarget Entry entry);
}