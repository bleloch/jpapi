import { Meaning } from "./meaning";
import { Reading } from "./reading";

export interface SemanticGroup {
  readings: Reading[];
  readonly meanings: Meaning[];
}
