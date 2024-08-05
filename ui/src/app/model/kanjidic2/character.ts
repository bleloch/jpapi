import { Codepoint } from "./codepoint";
import { Radical } from "./radical";
import { Metadata } from "./metadata";
import { DictionaryReference } from "./dictionaryReference";
import { QueryCode } from "./query_code";
import { Semantics } from "./semantics";

export interface Character {
  readonly codepoints: Codepoint[];
  readonly dictionaryReferences: DictionaryReference[];
  readonly literal: string;
  readonly metadata: Metadata;
  readonly queryCodes: QueryCode[];
  readonly radicals: Radical[];
  readonly semantics: Semantics;
}
