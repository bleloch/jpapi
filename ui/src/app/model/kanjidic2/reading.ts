import { WithElementAndType } from "../base/withElementAndType";

export interface Reading extends WithElementAndType {
  readonly onType: string;
  readonly rStatus: string;
}
