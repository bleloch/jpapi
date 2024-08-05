package ch.blelo.kanjiguide.model.mapper.kanjidic2;

import ch.blelo.kanjiguide.model.dto.kanjidic2.RadicalDto;
import ch.blelo.kanjiguide.model.entity.kanjidic2.Radical;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RadicalMapper {
    Radical toEntity(RadicalDto radicalDto);

    RadicalDto toDto(Radical radical);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Radical partialUpdate(RadicalDto radicalDto, @MappingTarget Radical radical);
}