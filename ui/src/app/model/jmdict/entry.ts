import { Kanji } from "./kanji";
import { Reading } from "./reading";
import { Sense } from "./sense";

export interface Entry {
  readonly entrySequence: number;
  readonly kanji: Kanji[];
  readonly readings: Reading[];
  readonly senses: Sense[];
}
