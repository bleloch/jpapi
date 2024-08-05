package ch.blelo.kanjiguide.model.mapper.jmdict;

import ch.blelo.kanjiguide.model.dto.jmdict.ReadingDto;
import ch.blelo.kanjiguide.model.entity.jmdict.JReading;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface JReadingMapper {
    JReading toEntity(ReadingDto readingDto);

    ReadingDto toDto(JReading reading);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    JReading partialUpdate(ReadingDto readingDto, @MappingTarget JReading reading);
}