import { Base } from "./base/base";

export interface Reading extends Base {
  readonly onType: string;
  readonly rStatus: string;
}
