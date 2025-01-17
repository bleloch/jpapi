package ch.blelo.jpapi.model.dto.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

/**
 *
 * @param id
 * @param element
 * @param kana
 * @param position
 */
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record FuriganaDto(
        @JsonIgnore
        long id,

        String element,

        String kana,

        Integer position
) {
}
