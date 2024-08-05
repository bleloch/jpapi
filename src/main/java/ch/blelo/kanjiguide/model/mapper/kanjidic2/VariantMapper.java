package ch.blelo.kanjiguide.model.mapper.kanjidic2;

import ch.blelo.kanjiguide.model.dto.kanjidic2.VariantDto;
import ch.blelo.kanjiguide.model.entity.kanjidic2.Variant;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface VariantMapper {
    Variant toEntity(VariantDto variantDto);

    VariantDto toDto(Variant variant);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Variant partialUpdate(VariantDto variantDto, @MappingTarget Variant variant);
}