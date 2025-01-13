package ch.blelo.jpapi.model.dto.serde;

import ch.blelo.jpapi.model.dto.common.RubyDto;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuriganaDeserializer extends JsonDeserializer<Map<String, List<RubyDto>>> {
    @Override
    public Map<String, List<RubyDto>> deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {
        Map<String, List<RubyDto>> result = new HashMap<>();

        ArrayNode arrayNode = jp.getCodec().readTree(jp);
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();

        for (JsonNode node : arrayNode) {
            String text = node.get("text").asText();
            String reading = node.get("reading").asText();
            String compositeKey = text + "#" + reading;

            List<RubyDto> furigana = mapper.treeToValue(
                    node.get("furigana"),
                    mapper.getTypeFactory().constructCollectionType(List.class, RubyDto.class)
            );

            result.put(compositeKey, furigana);
        }

        return result;
    }
}
