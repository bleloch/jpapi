import { Base } from "./base/base";

export interface DictionaryReference extends Base {
  readonly morohashiVolume: number;
  readonly morohashiPage: number;
}
