package ch.blelo.jpapi.model.mapper.jmdict;

import ch.blelo.jpapi.model.entity.jmdict.JMDictReadingFurigana;
import ch.blelo.jpapi.model.mapper.common.FuriganaMapper;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface JMDictReadingFuriganaMapper extends FuriganaMapper<JMDictReadingFurigana> {
}