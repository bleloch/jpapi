import { WithElementAndType } from "../base/withElementAndType";

export interface QueryCode extends WithElementAndType {
  readonly skipMisclassification: string;
}
