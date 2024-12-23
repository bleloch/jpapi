import { Base } from "../base/base";

export interface Reading extends Base {
  readonly element: string;
  readonly readingInformation: string[];
  readonly priorityInformation: string[];
  readonly alternativeReadings: string[];
}
