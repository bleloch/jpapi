package ch.blelo.jpapi.model.dto.jmnedict;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.Set;

@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record JMNEDictTranslationDto(
        @JsonIgnore
        long id,

        @JacksonXmlProperty(localName = "name_type")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<String> nameTypes,

        @JacksonXmlProperty(localName = "trans_det")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<JMNEDictTranslationDetailDto> details
) {
}
