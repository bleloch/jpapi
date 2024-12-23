import { Base } from "../base/base";

export interface LoanwordSource extends Base {
  readonly element: string;
  readonly languageCode: string;
  readonly semanticCoverage: string;
  readonly isConstructedFromSourceLanguageWord: boolean;
}
