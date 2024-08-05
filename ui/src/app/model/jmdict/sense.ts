import { LoanwordSource } from "./loanwordSource";
import { Gloss } from "./gloss";

export interface Sense {
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
