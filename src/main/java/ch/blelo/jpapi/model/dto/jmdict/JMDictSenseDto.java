package ch.blelo.jpapi.model.dto.jmdict;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.Set;

/**
 * <p>The sense element will record the translational equivalent
 * of the Japanese word, plus other related information.</p>
 * <p>Where there are several distinctly different meanings of
 * the word, multiple sense elements will be employed.</p>
 *
 * @param limitedToKanji           <p>These elements, if present, indicate that the sense is restricted
 *                                 to the lexeme represented by the kanji.</p>
 * @param limitedToReadings        <p>These elements, if present, indicate that the sense is restricted
 *                                 to the lexeme represented by the reading.</p>
 * @param partOfSpeech             <p>Part-of-speech information about the entry/sense. Should use
 *                                 appropriate entity codes. In general where there are multiple senses
 *                                 in an entry, the part-of-speech of an earlier sense will apply to
 *                                 later senses unless there is a new part-of-speech indicated.</p>
 * @param crossReferences          <p>This element is used to indicate a cross-reference to another
 *                                 entry with a similar or related meaning or sense. The content of
 *                                 this element is typically a kanji or reading in another entry. In some
 *                                 cases a kanji will be followed by a reading and/or a sense number to provide
 *                                 a precise target for the cross-reference. Where this happens, a JIS
 *                                 "centre-dot" (0x2126) is placed between the components of the
 *                                 cross-reference. The target kanji or reading must not contain a centre-dot.</p>
 * @param antonyms                 <p>This element is used to indicate another entry which is an
 *                                 antonym of the current entry/sense. The content of this element
 *                                 must exactly match that of a kanji or reading element in another entry.</p>
 * @param fieldsOfApplication      <p>Information about the field of application of the entry/sense.
 *                                 When absent, general application is implied. Entity coding for
 *                                 specific fields of application.</p>
 * @param miscellaneousInformation <p>This element is used for other relevant information about
 *                                 the entry/sense. As with part-of-speech, information will usually
 *                                 apply to several senses.</p>
 * @param senseInformation         <p>The sense-information elements provided for additional
 *                                 information to be recorded about a sense. Typical usage would
 *                                 be to indicate such things as level of currency of a sense, the
 *                                 regional variations, etc.</p>
 * @param loanwordSources          <p>See {@link JMDictLoanwordSourceDto}</p>
 * @param dialects                 <p>For words specifically associated with regional dialects in
 *                                 Japanese, the entity code for that dialect, e.g. ksb for Kansai-ben.</p>
 * @param glosses                  <p>See {@link JMDictGlossDto}</p>
 */
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record JMDictSenseDto(
        long id,

        @JacksonXmlProperty(localName = "stagk")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<String> limitedToKanji,

        @JacksonXmlProperty(localName = "stagr")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<String> limitedToReadings,

        @JacksonXmlProperty(localName = "pos")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<String> partOfSpeech,

        @JacksonXmlProperty(localName = "xref")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<String> crossReferences,

        @JacksonXmlProperty(localName = "ant")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<String> antonyms,

        @JacksonXmlProperty(localName = "field")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<String> fieldsOfApplication,

        @JacksonXmlProperty(localName = "misc")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<String> miscellaneousInformation,

        @JacksonXmlProperty(localName = "s_inf")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<String> senseInformation,

        @JacksonXmlProperty(localName = "lsource")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<JMDictLoanwordSourceDto> loanwordSources,

        @JacksonXmlProperty(localName = "dial")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<String> dialects,

        @JacksonXmlProperty(localName = "gloss")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<JMDictGlossDto> glosses
) {
}
