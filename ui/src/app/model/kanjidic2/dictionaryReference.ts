import { WithElementAndType } from "../base/withElementAndType";

export interface DictionaryReference extends WithElementAndType {
  readonly morohashiVolume: number;
  readonly morohashiPage: number;
}
