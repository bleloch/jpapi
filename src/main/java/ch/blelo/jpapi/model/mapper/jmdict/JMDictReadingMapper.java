package ch.blelo.jpapi.model.mapper.jmdict;

import ch.blelo.jpapi.model.dto.common.ReadingDto;
import ch.blelo.jpapi.model.entity.jmdict.JMDictReading;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface JMDictReadingMapper {
    JMDictReading toEntity(ReadingDto readingDto);

    ReadingDto toDto(JMDictReading reading);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    JMDictReading partialUpdate(ReadingDto readingDto, @MappingTarget JMDictReading reading);
}