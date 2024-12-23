import { Variant } from "./variant";
import { Base } from "../base/base";

export interface Metadata extends Base {
  readonly frequency: number;
  readonly schoolGrade: number;
  readonly jlptGrade: number;
  readonly strokeCount: number;
  readonly variants: Variant[];
  readonly radicalNames: string[];
}
