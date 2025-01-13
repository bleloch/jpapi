package ch.blelo.jpapi.model.dto.kanjidic2;

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
public record Kanjidic2MeaningDto(
        long id,

        @JacksonXmlText
        String element,

        @JacksonXmlProperty(localName = "m_lang", isAttribute = true)
        String languageCode
) {
    public static class Kanjidic2MeaningDtoBuilder {
        Kanjidic2MeaningDtoBuilder() {
            this.languageCode = "en";
        }
    }
}