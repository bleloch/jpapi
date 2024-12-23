package ch.blelo.kanjiguide.model.dto.jmdict;

import ch.blelo.kanjiguide.model.dto.serde.RelaxedBooleanDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

/**
 * <p>This element records the information about the source
 * language(s) of a loanword/gairaigo.</p>
 * <p>If the source language is other than English, the language
 * is indicated by the xml:lang attribute.</p>
 * <p>The element element (if any) is the source word or phrase.</p>
 *
 * @param element                             <p>The foreign word from which the loanword derives.</p>
 * @param languageCode                        <p>The xml:lang attribute defines the target language of the
 *                                            gloss. It will be coded using the three-letter language code from
 *                                            the ISO 639 standard. When absent, the element "eng" (i.e. English)
 *                                            is the default element.</p>
 * @param semanticCoverage                    <p>The ls_type attribute indicates whether the lsource element
 *                                            fully or partially describes the source word or phrase of the
 *                                            loanword. If absent, it will have the implied element of "full",
 *                                            otherwise it will contain "part".</p>
 * @param isConstructedFromSourceLanguageWord <p>The xml:lang attribute defines the language(s) from which
 *                                            a loanword is drawn.  It will be coded using the three-letter language
 *                                            code from the ISO 639-2 standard. When absent, the element "eng" (i.e.
 *                                            English) is the default element. The bibliographic (B) codes are used.</p>
 */
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record LoanwordSourceDto(
        long id,

        @JacksonXmlText
        String element,

        @JacksonXmlProperty(localName = "lang", isAttribute = true)
        String languageCode,

        @JacksonXmlProperty(localName = "ls_type", isAttribute = true)
        String semanticCoverage,

        @JsonDeserialize(using = RelaxedBooleanDeserializer.class)
        @JacksonXmlProperty(localName = "ls_wasei", isAttribute = true)
        boolean isConstructedFromSourceLanguageWord
) {
    public static class LoanwordSourceDtoBuilder {
        private String languageCode = "eng";
        private String semanticCoverage = "full";
        private boolean isConstructedFromSourceLanguageWord = false;
    }
}
