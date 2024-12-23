import { Meaning } from "./meaning";
import { Reading } from "./reading";
import { Base } from "../base/base";

export interface SemanticGroup extends Base {
  readings: Reading[];
  readonly meanings: Meaning[];
}
