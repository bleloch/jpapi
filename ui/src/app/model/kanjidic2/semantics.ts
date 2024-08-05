import { SemanticGroup } from "./semanticGroup";

export interface Semantics {
  readonly semanticGroups: SemanticGroup[];
  readonly nanori: string[];
}
