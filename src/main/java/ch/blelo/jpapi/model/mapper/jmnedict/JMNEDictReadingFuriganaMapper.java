package ch.blelo.jpapi.model.mapper.jmnedict;

import ch.blelo.jpapi.model.entity.jmnedict.JMNEDictReadingFurigana;
import ch.blelo.jpapi.model.mapper.common.FuriganaMapper;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface JMNEDictReadingFuriganaMapper extends FuriganaMapper<JMNEDictReadingFurigana> {
}