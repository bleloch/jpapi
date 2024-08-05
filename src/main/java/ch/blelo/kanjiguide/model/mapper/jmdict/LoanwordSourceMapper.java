package ch.blelo.kanjiguide.model.mapper.jmdict;

import ch.blelo.kanjiguide.model.dto.jmdict.LoanwordSourceDto;
import ch.blelo.kanjiguide.model.entity.jmdict.LoanwordSource;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoanwordSourceMapper {
    LoanwordSource toEntity(LoanwordSourceDto loanwordSourceDto);

    LoanwordSourceDto toDto(LoanwordSource loanwordSource);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    LoanwordSource partialUpdate(LoanwordSourceDto loanwordSourceDto, @MappingTarget LoanwordSource loanwordSource);
}