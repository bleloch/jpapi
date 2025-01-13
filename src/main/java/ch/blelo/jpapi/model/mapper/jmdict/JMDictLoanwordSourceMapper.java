package ch.blelo.jpapi.model.mapper.jmdict;

import ch.blelo.jpapi.model.dto.jmdict.JMDictLoanwordSourceDto;
import ch.blelo.jpapi.model.entity.jmdict.JMDictLoanwordSource;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface JMDictLoanwordSourceMapper {
    JMDictLoanwordSource toEntity(JMDictLoanwordSourceDto loanwordSourceDto);

    JMDictLoanwordSourceDto toDto(JMDictLoanwordSource loanwordSource);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    JMDictLoanwordSource partialUpdate(JMDictLoanwordSourceDto loanwordSourceDto, @MappingTarget JMDictLoanwordSource loanwordSource);
}