package ch.blelo.kanjiguide.model.dto.kanjidic2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record MeaningDto(
        //@JacksonXmlText
        String element,

        //@JacksonXmlProperty(localName = "m_lang", isAttribute = true)
        String languageCode
) {
    public static class MeaningDtoBuilder {
        private String languageCode = "en";
    }
}