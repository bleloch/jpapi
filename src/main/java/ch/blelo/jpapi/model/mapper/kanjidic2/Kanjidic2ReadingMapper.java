package ch.blelo.jpapi.model.mapper.kanjidic2;

import ch.blelo.jpapi.model.dto.kanjidic2.Kanjidic2ReadingDto;
import ch.blelo.jpapi.model.entity.kanjidic2.Kanjidic2Reading;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface Kanjidic2ReadingMapper {
    Kanjidic2Reading toEntity(Kanjidic2ReadingDto readingDto);

    Kanjidic2ReadingDto toDto(Kanjidic2Reading Reading);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Kanjidic2Reading partialUpdate(Kanjidic2ReadingDto readingDto, @MappingTarget Kanjidic2Reading Reading);
}