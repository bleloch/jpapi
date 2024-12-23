import { LoanwordSource } from "./loanwordSource";
import { Gloss } from "./gloss";
import { Base } from "../base/base";

export interface Sense extends Base {
  readonly limitedToKanji: string[];
  readonly limitedToReadings: string[];
  readonly partOfSpeech: string[];
  readonly crossReferences: string[];
  readonly antonyms: string[];
  readonly fieldsOfApplication: string[];
  readonly miscellaneousInformation: string[];
  readonly senseInformation: string[];
  readonly loanwordSources: LoanwordSource[];
  readonly dialects: string[];
  readonly glosses: Gloss[];
}
