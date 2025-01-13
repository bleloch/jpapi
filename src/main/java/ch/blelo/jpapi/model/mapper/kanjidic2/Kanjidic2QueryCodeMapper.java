package ch.blelo.jpapi.model.mapper.kanjidic2;

import ch.blelo.jpapi.model.dto.kanjidic2.Kanjidic2QueryCodeDto;
import ch.blelo.jpapi.model.entity.kanjidic2.Kanjidic2QueryCode;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface Kanjidic2QueryCodeMapper {
    Kanjidic2QueryCode toEntity(Kanjidic2QueryCodeDto queryCodeDto);

    Kanjidic2QueryCodeDto toDto(Kanjidic2QueryCode queryCode);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Kanjidic2QueryCode partialUpdate(Kanjidic2QueryCodeDto queryCodeDto, @MappingTarget Kanjidic2QueryCode queryCode);
}