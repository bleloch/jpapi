package ch.blelo.kanjiguide.model.mapper.jmdict;

import ch.blelo.kanjiguide.model.dto.jmdict.SenseDto;
import ch.blelo.kanjiguide.model.entity.jmdict.Sense;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SenseMapper {
    Sense toEntity(SenseDto senseDto);

    SenseDto toDto(Sense sense);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Sense partialUpdate(SenseDto senseDto, @MappingTarget Sense sense);
}