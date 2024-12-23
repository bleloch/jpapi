import { Codepoint } from "./codepoint";
import { Radical } from "./radical";
import { Metadata } from "./metadata";
import { DictionaryReference } from "./dictionaryReference";
import { QueryCode } from "./queryCode";
import { Semantics } from "./semantics";
import { Base } from "../base/base";

export interface Character extends Base {
  readonly codepoints: Codepoint[];
  readonly dictionaryReferences: DictionaryReference[];
  readonly literal: string;
  readonly metadata: Metadata;
  readonly queryCodes: QueryCode[];
  readonly radicals: Radical[];
  readonly semantics: Semantics;
  readonly words: Object[];
}
