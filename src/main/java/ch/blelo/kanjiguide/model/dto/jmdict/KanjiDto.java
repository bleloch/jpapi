package ch.blelo.kanjiguide.model.dto.jmdict;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>The kanji element, or in its absence, the reading element, is
 * the defining component of each entry.</p>
 * <p>The overwhelming majority of entries will have a single kanji
 * element associated with a word in Japanese.</p>
 * <p>Where there are multiple kanji elements within an entry, they
 * will be orthographical variants of the same word, either using
 * variations in okurigana, or alternative and equivalent kanji.</p>
 * <p>Common "mis-spellings" may be included, provided they are
 * associated with appropriate information fields.</p>
 * <p>Synonyms are not included; they may be indicated in the
 * cross-reference field associated with the sense element.</p>
 *
 * @param element                <p>This element will contain a word or short phrase in Japanese
 *                               which is written using at least one non-kana character (usually kanji,
 *                               but can be other characters). The valid characters are
 *                               kanji, kana, related characters such as chouon and kurikaeshi, and
 *                               in exceptional cases, letters from other alphabets.</p>
 * @param orthographyInformation <p>This is a coded information field related specifically to the
 *                               orthography of the kanji, and will typically indicate some unusual
 *                               aspect, such as okurigana irregularity.</p>
 * @param priorityInformation    <p>This field is provided to record
 *                               information about the relative priority of the entry, and consists
 *                               of codes indicating the word appears in various references which
 *                               can be taken as an indication of the frequency with which the word
 *                               is used. This field is intended for use either by applications which
 *                               want to concentrate on entries of a particular priority, or to
 *                               generate subset files.
 *                               The current values in this field are:
 *                               <ul>
 *                               <li>
 *                               news1/2: appears in the "wordfreq" file compiled by Alexandre Girardi
 *                               from the Mainichi Shimbun. (See the Monash ftp archive for a copy.)
 *                               Words in the first 12,000 in that file are marked "news1" and words
 *                               in the second 12,000 are marked "news2".
 *                               </li>
 *                               <li>
 *                               ichi1/2: appears in the "Ichimango goi bunruishuu", Senmon Kyouiku
 *                               Publishing, Tokyo, 1998. (The entries marked "ichi2" were
 *                               demoted from ichi1 because they were observed to have low
 *                               frequencies in the WWW and newspapers.)
 *                               </li>
 *                               <li>
 *                               spec1 and spec2: a small number of words use this marker when they
 *                               are detected as being common, but are not included in other lists.
 *                               </li>
 *                               <li>
 *                               gai1/2: common loanwords, based on the wordfreq file.
 *                               </li>
 *                               <li>
 *                               nfxx: this is an indicator of frequency-of-use ranking in the
 *                               wordfreq file. "xx" is the number of the set of 500 words in which
 *                               the entry can be found, with "01" assigned to the first 500, "02"
 *                               to the second, and so on. (The entries with news1, ichi1, spec1, spec2
 *                               and gai1 values are marked with a "(P)" in the EDICT and EDICT2
 *                               files.)
 *                               </li>
 *                               </ul>
 *                               The reason both the kanji and reading elements are tagged is because
 *                               on occasions a priority is only associated with a particular
 *                               kanji/reading pair.
 *                               </p><p>
 */
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record KanjiDto(
        //@JacksonXmlProperty(localName = "keb")
        String element,

        //@JacksonXmlProperty(localName = "ke_inf")
        //@JacksonXmlElementWrapper(useWrapping = false)
        Set<String> orthographyInformation,

        //@JacksonXmlProperty(localName = "ke_pri")
        //@JacksonXmlElementWrapper(useWrapping = false)
        Set<String> priorityInformation
) {
        public static class KanjiDtoBuilder {
                private Set<String> orthographyInformation = new HashSet<>();
                private Set<String> priorityInformation = new HashSet<>();
        }
}
