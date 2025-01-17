package ch.blelo.jpapi.model.dto.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.Set;

/**
 * <p><b>Note:</b> Used by both JMDict & JMNEDict schemas.</p>
 * <p>The reading element typically contains the valid readings
 * of the word(s) in the kanji element using modern kanadzukai.</p>
 * <p>Where there are multiple reading elements, they will typically be
 * alternative readings of the kanji element.</p>
 * <p>In the absence of a
 * kanji element, i.e. in the case of a word or phrase written
 * entirely in kana, these elements will define the entry.</p>
 *
 * @param element             <p>This element content is restricted to kana and related
 *                            characters such as chouon and kurikaeshi. Kana usage will be
 *                            consistent between the keb and reb elements; e.g. if the keb
 *                            contains katakana, so too will the reb.</p>
 * @param nokanji             <p>This element, which will usually have a null element, indicates
 *                            that the reb, while associated with the keb, cannot be regarded
 *                            as a true reading of the kanji. It is typically used for words
 *                            such as foreign place names, gairaigo which can be in kanji or
 *                            katakana, etc.</p>
 * @param readingInformation  <p>General coded information pertaining to the specific reading.
 *                            Typically it will be used to indicate some unusual aspect of
 *                            the reading.</p>
 * @param priorityInformation <p>This field is provided to record
 *                            information about the relative priority of the entry, and consists
 *                            of codes indicating the word appears in various references which
 *                            can be taken as an indication of the frequency with which the word
 *                            is used. This field is intended for use either by applications which
 *                            want to concentrate on entries of a particular priority, or to
 *                            generate subset files.
 *                            The current values in this field are:
 *                            <ul>
 *                            <li>
 *                            news1/2: appears in the "wordfreq" file compiled by Alexandre Girardi
 *                            from the Mainichi Shimbun. (See the Monash ftp archive for a copy.)
 *                            Words in the first 12,000 in that file are marked "news1" and words
 *                            in the second 12,000 are marked "news2".
 *                            </li>
 *                            <li>
 *                            ichi1/2: appears in the "Ichimango goi bunruishuu", Senmon Kyouiku
 *                            Publishing, Tokyo, 1998. (The entries marked "ichi2" were
 *                            demoted from ichi1 because they were observed to have low
 *                            frequencies in the WWW and newspapers.)
 *                            </li>
 *                            <li>
 *                            spec1 and spec2: a small number of words use this marker when they
 *                            are detected as being common, but are not included in other lists.
 *                            </li>
 *                            <li>
 *                            gai1/2: common loanwords, based on the wordfreq file.
 *                            </li>
 *                            <li>
 *                            nfxx: this is an indicator of frequency-of-use ranking in the
 *                            wordfreq file. "xx" is the number of the set of 500 words in which
 *                            the entry can be found, with "01" assigned to the first 500, "02"
 *                            to the second, and so on. (The entries with news1, ichi1, spec1, spec2
 *                            and gai1 values are marked with a "(P)" in the EDICT and EDICT2
 *                            files.)
 *                            </li>
 *                            </ul>
 *                            The reason both the kanji and reading elements are tagged is because
 *                            on occasions a priority is only associated with a particular
 *                            kanji/reading pair.
 *                            </p><p>
 * @param alternativeReadings <p>This element is used to indicate when the reading only applies
 *                            to a subset of the kanji elements in the entry. In its absence, all
 *                            readings apply to all kanji elements. The contents of this element
 *                            must exactly match those of one of the kanji elements.</p>
 */
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record ReadingDto(
        @JsonIgnore
        long id,

        @JacksonXmlProperty(localName = "reb")
        String element,

        @JacksonXmlProperty(localName = "re_nokanji")
        boolean nokanji,

        @JacksonXmlProperty(localName = "re_inf")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<String> readingInformation,

        @JacksonXmlProperty(localName = "re_pri")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<String> priorityInformation,

        @JacksonXmlProperty(localName = "re_restr")
        @JacksonXmlElementWrapper(useWrapping = false)
        Set<String> alternativeReadings,

        Set<FuriganaDto> furigana
) {
}