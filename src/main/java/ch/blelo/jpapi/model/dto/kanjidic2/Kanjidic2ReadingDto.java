package ch.blelo.jpapi.model.dto.kanjidic2;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public record Kanjidic2ReadingDto(
        @JsonIgnore
        long id,

        @JacksonXmlText
        String element,

        @JacksonXmlProperty(localName = "r_type", isAttribute = true)
        String type,

        @JacksonXmlProperty(localName = "on_type", isAttribute = true)
        String onType,

        @JacksonXmlProperty(localName = "r_status", isAttribute = true)
        String rStatus
) {
}
