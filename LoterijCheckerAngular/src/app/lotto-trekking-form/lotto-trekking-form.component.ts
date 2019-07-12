import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Trekking} from "../home/trekking";
import {logging} from "selenium-webdriver";
import Entry = logging.Entry;
import {FormArray, FormBuilder, FormControl} from "@angular/forms";
import {kebabToCamelCase} from "codelyzer/util/utils";

@Component({
  selector: 'app-lotto-trekking-form',
  templateUrl: './lotto-trekking-form.component.html',
  styleUrls: ['./lotto-trekking-form.component.css']
})
export class LottoTrekkingFormComponent implements OnInit {

  @Output() getLottoProfits = new EventEmitter<Trekking>();
  trekking: Trekking;
  keys;
  values;
  trekkingForm = this.fb.group({
    winstVerdeling: this.fb.array([]),
    winningNumbers: this.fb.array([]),
    extraNumber: ['0']
  });
  constructor(private fb : FormBuilder) {
    this.trekking = new Trekking();
    this.keys = Array.from(this.trekking.winstVerdeling.keys());
    this.values = Array.from(this.trekking.winstVerdeling.values());
    this.formArraysFillZeros();
  }

  formArraysFillZeros(){
    this.winstVerdeling.clear();
    this.winstVerdeling.push(this.fb.control('0'));
    this.winstVerdeling.push(this.fb.control('0'));
    this.winstVerdeling.push(this.fb.control('0'));
    this.winstVerdeling.push(this.fb.control('0'));
    this.winstVerdeling.push(this.fb.control('0'));
    this.winstVerdeling.push(this.fb.control('0'));
    this.winstVerdeling.push(this.fb.control('0'));
    this.winstVerdeling.push(this.fb.control('0'));
    this.winstVerdeling.push(this.fb.control('0'));
    this.winningNumbers.clear();
    this.winningNumbers.push(this.fb.control('0'));
    this.winningNumbers.push(this.fb.control('0'));
    this.winningNumbers.push(this.fb.control('0'));
    this.winningNumbers.push(this.fb.control('0'));
    this.winningNumbers.push(this.fb.control('0'));
    this.winningNumbers.push(this.fb.control('0'));
  }
  get winstVerdeling() {
    return this.trekkingForm.get('winstVerdeling') as FormArray;
  }

  get winningNumbers(){
    return this.trekkingForm.get('winningNumbers') as FormArray;
  }

  get extraNumber(){
    return this.trekkingForm.get('extraNumber') as FormControl;
  }

  checkProfits(){
    console.log('---------------');
    let k = Array.from(this.trekking.winstVerdeling.keys());
    let v = Array.from(this.trekking.winstVerdeling.values());
    this.winstVerdeling.controls.forEach((c, index) => {
      this.trekking.winstVerdeling.set(k[index],c.value);
    });
    this.trekking.numbers = [];
    this.winningNumbers.controls.forEach(e => {
      this.trekking.numbers.push(e.value);
    });

    for(let en of this.trekking.winstVerdeling.entries()){
      console.log(en[0] + " = " + en[1]);
    }
    console.log('winning numbers:');
    for(let n of this.trekking.numbers){
      console.log(n);
    }
    console.log('extra:');
    this.trekking.extraNumber = this.extraNumber.value;
    console.log(this.trekking.extraNumber);
    this.getLottoProfits.next(this.trekking);
  }

  ngOnInit() {

  }


}
