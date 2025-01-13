package ch.blelo.jpapi.model.mapper.kanjidic2;

import ch.blelo.jpapi.model.dto.kanjidic2.Kanjidic2CodepointDto;
import ch.blelo.jpapi.model.entity.kanjidic2.Kanjidic2Codepoint;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface Kanjidic2CodepointMapper {
    Kanjidic2Codepoint toEntity(Kanjidic2CodepointDto codepointDto);

    Kanjidic2CodepointDto toDto(Kanjidic2Codepoint codepoint);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Kanjidic2Codepoint partialUpdate(Kanjidic2CodepointDto codepointDto, @MappingTarget Kanjidic2Codepoint codepoint);
}