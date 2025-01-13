package ch.blelo.jpapi.model.dto.jmnedict;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record JMNEDictTranslationDetailDto(
        long id,

        @JacksonXmlText
        String element,

        @JacksonXmlProperty(localName= "lang", isAttribute = true)
        String languageCode
) {
    public static class JMNEDictTranslationDetailDtoBuilder {
        JMNEDictTranslationDetailDtoBuilder() {
            this.languageCode = "eng";
        }

        JMNEDictTranslationDetailDtoBuilder(String element) {
            this();
            this.element = element;
        }
    }
}
