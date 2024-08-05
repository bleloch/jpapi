package ch.blelo.kanjiguide.model.jmdict.dto.serde;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * Taken from https://www.wissel.net/blog/2022/05/yes-no-maybe-booleans.html
 */
public class RelaxedBooleanDeserializer extends JsonDeserializer<Boolean> {

    @Override
    public Boolean deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

        char[] chars = p.getTextCharacters();
        int start = p.getTextOffset();
        char isbool = chars[start];

        /* What is true
         * - boolean true
         * - Letters: T,t (True), Y,y (Yes sir), A,a (active), I,i (isActive), E,e (enabled), J,j (Jawohl), S,s (si senior)
         * - Numbers: anything not starting with 0 (0.3 would be false)
         */
        return "TtYyeAaEIiJjSs123456789".contains(String.valueOf(isbool))
                ? Boolean.TRUE
                : Boolean.FALSE;
    }
}
