import { Base } from "../base/base";

export interface Meaning extends Base {
  readonly element: string;
  readonly languageCode: string;
}
