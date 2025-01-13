package ch.blelo.jpapi.model.mapper.kanjidic2;

import ch.blelo.jpapi.model.dto.kanjidic2.Kanjidic2DictionaryReferenceDto;
import ch.blelo.jpapi.model.entity.kanjidic2.Kanjidic2DictionaryReference;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface Kanjidic2DictionaryReferenceMapper {
    Kanjidic2DictionaryReference toEntity(Kanjidic2DictionaryReferenceDto dictionaryReferenceDto);

    Kanjidic2DictionaryReferenceDto toDto(Kanjidic2DictionaryReference dictionaryReference);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Kanjidic2DictionaryReference partialUpdate(Kanjidic2DictionaryReferenceDto dictionaryReferenceDto, @MappingTarget Kanjidic2DictionaryReference dictionaryReference);
}