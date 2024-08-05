package ch.blelo.kanjiguide.model.mapper.kanjidic2;

import ch.blelo.kanjiguide.model.dto.kanjidic2.DictionaryReferenceDto;
import ch.blelo.kanjiguide.model.entity.kanjidic2.DictionaryReference;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DictionaryReferenceMapper {
    DictionaryReference toEntity(DictionaryReferenceDto dictionaryReferenceDto);

    DictionaryReferenceDto toDto(DictionaryReference dictionaryReference);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DictionaryReference partialUpdate(DictionaryReferenceDto dictionaryReferenceDto, @MappingTarget DictionaryReference dictionaryReference);
}