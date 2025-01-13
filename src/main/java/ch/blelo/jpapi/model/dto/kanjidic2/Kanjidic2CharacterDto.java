package ch.blelo.jpapi.model.dto.kanjidic2;

import ch.blelo.jpapi.model.dto.jmdict.JMDictEntryDto;
import ch.blelo.jpapi.model.dto.serde.Kanjidic2Serializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.Set;

/**
 * <p>Represents one of the 15,849 kanji described in the <a href="http://nihongo.monash.edu/kanjidic2/index.html">Kanjidic2</a> dataset, which sources from the following
 * character sets:</p>
 * <p>
 *     <ul>
 *         <li><a href="https://en.wikipedia.org/wiki/JIS_X_0208">JIS X 0208</a></li>
 *         <li><a href="https://en.wikipedia.org/wiki/JIS_X_0212">JIS X 0212</a></li>
 *         <li><a href="https://en.wikipedia.org/wiki/JIS_X_0213">JIS X 0213</a> where:
 *              <ol>
 *                  <li>The 2,741 kanji which are also in JIS X 0212 have
 * 		            JIS X 0213 code-points (kuten) added to the existing entry</li>
 * 		            <li>The 952 "new" kanji have new entries.</li>
 *              </ol>
 *         </li>
 *     </ul>
 * </p>
 *
 * @param literal               <p>The character itself in UTF-8 coding.</p>
 * @param codepoints            <p>See {@link Kanjidic2CodepointDto}</p>
 * @param radicals              <p>See {@link Kanjidic2RadicalDto}</p>
 * @param metadata              <p>See {@link Kanjidic2MetadataDto}</p>
 * @param dictionaryReferences  <p>See {@link Kanjidic2DictionaryReferenceDto}</p>
 * @param queryCodes            <p>See {@link Kanjidic2QueryCodeDto}</p>
 * @param semantics             <p>See {@link Kanjidic2SemanticsDto}</p>
 * @param words                 <p>See {@link JMDictEntryDto}. This field represents a one-way binding between
 *                              kanji, and words including that kanji, using the JMDict dataset</p>
 */
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonSerialize(using = Kanjidic2Serializer.class)
public record Kanjidic2CharacterDto(
        long id,

        @JacksonXmlProperty(localName = "literal")
        String literal,

        @JacksonXmlElementWrapper(localName = "codepoint")
        Set<Kanjidic2CodepointDto> codepoints,

        @JacksonXmlElementWrapper(localName = "radical")
        Set<Kanjidic2RadicalDto> radicals,

        @JacksonXmlProperty(localName = "misc")
        Kanjidic2MetadataDto metadata,

        @JacksonXmlElementWrapper(localName = "dic_number")
        Set<Kanjidic2DictionaryReferenceDto> dictionaryReferences,

        @JacksonXmlElementWrapper(localName = "query_code")
        Set<Kanjidic2QueryCodeDto> queryCodes,

        @JacksonXmlProperty(localName = "reading_meaning")
        Kanjidic2SemanticsDto semantics,

        Set<JMDictEntryDto> words
) {
}
