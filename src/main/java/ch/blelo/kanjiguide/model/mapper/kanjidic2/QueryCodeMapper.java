package ch.blelo.kanjiguide.model.mapper.kanjidic2;

import ch.blelo.kanjiguide.model.dto.kanjidic2.QueryCodeDto;
import ch.blelo.kanjiguide.model.entity.kanjidic2.QueryCode;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface QueryCodeMapper {
    QueryCode toEntity(QueryCodeDto queryCodeDto);

    QueryCodeDto toDto(QueryCode queryCode);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    QueryCode partialUpdate(QueryCodeDto queryCodeDto, @MappingTarget QueryCode queryCode);
}