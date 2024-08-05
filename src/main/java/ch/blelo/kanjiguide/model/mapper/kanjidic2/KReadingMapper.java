package ch.blelo.kanjiguide.model.mapper.kanjidic2;

import ch.blelo.kanjiguide.model.dto.kanjidic2.ReadingDto;
import ch.blelo.kanjiguide.model.entity.kanjidic2.KReading;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface KReadingMapper {
    KReading toEntity(ReadingDto readingDto);

    ReadingDto toDto(KReading KReading);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    KReading partialUpdate(ReadingDto readingDto, @MappingTarget KReading KReading);
}