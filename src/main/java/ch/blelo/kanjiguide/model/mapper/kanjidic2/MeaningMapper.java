package ch.blelo.kanjiguide.model.mapper.kanjidic2;

import ch.blelo.kanjiguide.model.dto.kanjidic2.MeaningDto;
import ch.blelo.kanjiguide.model.entity.kanjidic2.Meaning;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MeaningMapper {
    Meaning toEntity(MeaningDto meaningDto);

    MeaningDto toDto(Meaning meaning);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Meaning partialUpdate(MeaningDto meaningDto, @MappingTarget Meaning meaning);
}