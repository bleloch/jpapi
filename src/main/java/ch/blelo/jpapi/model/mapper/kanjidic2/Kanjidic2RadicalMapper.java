package ch.blelo.jpapi.model.mapper.kanjidic2;

import ch.blelo.jpapi.model.dto.kanjidic2.Kanjidic2RadicalDto;
import ch.blelo.jpapi.model.entity.kanjidic2.Kanjidic2Radical;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface Kanjidic2RadicalMapper {
    Kanjidic2Radical toEntity(Kanjidic2RadicalDto radicalDto);

    Kanjidic2RadicalDto toDto(Kanjidic2Radical radical);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Kanjidic2Radical partialUpdate(Kanjidic2RadicalDto radicalDto, @MappingTarget Kanjidic2Radical radical);
}