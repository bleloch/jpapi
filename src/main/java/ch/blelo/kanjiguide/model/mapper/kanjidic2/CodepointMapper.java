package ch.blelo.kanjiguide.model.mapper.kanjidic2;

import ch.blelo.kanjiguide.model.dto.kanjidic2.CodepointDto;
import ch.blelo.kanjiguide.model.entity.kanjidic2.Codepoint;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CodepointMapper {
    Codepoint toEntity(CodepointDto codepointDto);

    CodepointDto toDto(Codepoint codepoint);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Codepoint partialUpdate(CodepointDto codepointDto, @MappingTarget Codepoint codepoint);
}