import { Kanji } from "./kanji";
import { Reading } from "./reading";
import { Sense } from "./sense";
import { Base } from "../base/base";

export interface Entry extends Base {
  readonly entrySequence: number;
  readonly kanji: Kanji[];
  readonly readings: Reading[];
  readonly senses: Sense[];
  readonly linkedCharacters: Object[];
}
