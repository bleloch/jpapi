import { Base } from "../base/base";

export interface Kanji extends Base {
  readonly element: string;
  readonly orthographyInformation: string[];
  readonly priorityInformation: string[];
}
