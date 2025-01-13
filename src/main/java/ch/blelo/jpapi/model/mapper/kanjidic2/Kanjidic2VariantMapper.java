package ch.blelo.jpapi.model.mapper.kanjidic2;

import ch.blelo.jpapi.model.dto.kanjidic2.Kanjidic2VariantDto;
import ch.blelo.jpapi.model.entity.kanjidic2.Kanjidic2Variant;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface Kanjidic2VariantMapper {
    Kanjidic2Variant toEntity(Kanjidic2VariantDto variantDto);

    Kanjidic2VariantDto toDto(Kanjidic2Variant variant);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Kanjidic2Variant partialUpdate(Kanjidic2VariantDto variantDto, @MappingTarget Kanjidic2Variant variant);
}