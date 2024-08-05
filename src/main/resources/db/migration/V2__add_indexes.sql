CREATE INDEX jmd_kanji_element
ON jmd_kanji (entry_id, element);

CREATE INDEX jmd_reading_element
ON jmd_reading (entry_id, element);

CREATE INDEX jmd_gloss_element
ON jmd_gloss (sense_id, element);