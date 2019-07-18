export class Trekking {
  numbers: number[];
  extraNumber: number;
  winstVerdeling: Map<string,number>;
  constructor() {
    this.winstVerdeling = new Map<string, number>();
    this.winstVerdeling.set("3+", 0.0);
    this.winstVerdeling.set("4", 0.0);
    this.winstVerdeling.set("4+", 0.0);
    this.winstVerdeling.set("5", 0.0);
    this.winstVerdeling.set("5+", 0.0);
    this.winstVerdeling.set("6", 0.0);
    this.numbers = [];
    this.extraNumber = 0;
  }

}
