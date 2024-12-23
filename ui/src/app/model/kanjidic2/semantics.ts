import { SemanticGroup } from "./semanticGroup";
import { Base } from "../base/base";

export interface Semantics extends Base {
  readonly semanticGroups: SemanticGroup[];
  readonly nanori: string[];
}
