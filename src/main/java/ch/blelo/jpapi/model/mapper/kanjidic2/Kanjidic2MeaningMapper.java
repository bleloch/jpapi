package ch.blelo.jpapi.model.mapper.kanjidic2;

import ch.blelo.jpapi.model.dto.kanjidic2.Kanjidic2MeaningDto;
import ch.blelo.jpapi.model.entity.kanjidic2.Kanjidic2Meaning;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface Kanjidic2MeaningMapper {
    Kanjidic2Meaning toEntity(Kanjidic2MeaningDto meaningDto);

    Kanjidic2MeaningDto toDto(Kanjidic2Meaning meaning);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Kanjidic2Meaning partialUpdate(Kanjidic2MeaningDto meaningDto, @MappingTarget Kanjidic2Meaning meaning);
}