import { Base } from "../base/base";

export interface Gloss extends Base {
  readonly element: string;
  readonly languageCode: string;
  readonly gender: string;
  readonly semanticProperty: string;
}
