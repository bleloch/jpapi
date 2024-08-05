import { Base } from "./base/base";

export interface QueryCode extends Base {
  readonly skipMisclassification: string;
}
