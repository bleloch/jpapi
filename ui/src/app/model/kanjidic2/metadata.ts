import { Variant } from "./variant";

export interface Metadata {
  readonly frequency: number;
  readonly schoolGrade: number;
  readonly jlptGrade: number;
  readonly strokeCount: number;
  readonly variants: Variant[];
  readonly radicalNames: string[];
}
