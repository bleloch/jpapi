package ch.blelo.kanjiguide.model.dto.serde;

import ch.blelo.kanjiguide.model.dto.jmdict.EntryDto;
import ch.blelo.kanjiguide.model.dto.kanjidic2.CharacterDto;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class EntrySerializer extends StdSerializer<EntryDto> {
    public EntrySerializer() {
        this(null);
    }

    public EntrySerializer(Class<EntryDto> c) {
        super(c);
    }

    @Override
    public void serialize(EntryDto value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();

        gen.writeNumberField("id", value.id());

        gen.writeNumberField("entrySequence", value.entrySequence());

        if (!value.kanji().isEmpty()) {
            gen.writeObjectField("kanji", value.kanji());
        }

        gen.writeObjectField("readings", value.readings());

        gen.writeObjectField("senses", value.senses());

        gen.writeArrayFieldStart("kanjiMatches");
        if (!value.linkedCharacters().isEmpty()) {
            for (CharacterDto c : value.linkedCharacters()) {
                gen.writeString(c.literal());
            }
        }
        gen.writeEndArray();

        gen.writeEndObject();
    }
}
