import { Base } from "./base";

export interface WithElementAndType extends Base {
  readonly element: string;
  readonly type: string
}
