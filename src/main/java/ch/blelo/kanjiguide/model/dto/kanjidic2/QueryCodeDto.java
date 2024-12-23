package ch.blelo.kanjiguide.model.dto.kanjidic2;

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
public record QueryCodeDto(
        long id,

        @JacksonXmlText
        String element,

        @JacksonXmlProperty(isAttribute = true, localName = "qc_type")
        String type,

        @JacksonXmlProperty(isAttribute = true, localName = "skip_misclass")
        String skipMisclassification
) {
}
