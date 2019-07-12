import { Component, OnInit } from '@angular/core';
import {LottoRoosterForm} from "./lottoRoosterForm";
import {FormControl, FormBuilder, FormArray} from "@angular/forms";
import {log} from "util";
import {HomeService} from "../home/home.service";
import {subscribeOn} from "rxjs/operators";
import { Output, EventEmitter } from '@angular/core'


@Component({
  selector: 'app-lotto-rooster-form',
  templateUrl: './lotto-rooster-form.component.html',
  styleUrls: ['./lotto-rooster-form.component.css']
})
export class LottoRoosterFormComponent implements OnInit {

  @Output() getRoosters = new EventEmitter<string>();
  constructor(private fb : FormBuilder, private homeService:HomeService) {
      this.roosterFillZeros();
  }

  lottoRooster = new LottoRoosterForm([]);
  roosterForm = this.fb.group({
  numbers: this.fb.array([
                         ])
  });
  get numbers() {

    return this.roosterForm.get('numbers') as FormArray;
  }
  ngOnInit() {
  }


  submitted = false;

  roosterFillZeros(){
    this.numbers.clear();
    this.numbers.push(this.fb.control('0'));
    this.numbers.push(this.fb.control('0'));
    this.numbers.push(this.fb.control('0'));
    this.numbers.push(this.fb.control('0'));
    this.numbers.push(this.fb.control('0'));
    this.numbers.push(this.fb.control('0'));
  }
  addRooster(){
    this.lottoRooster.numbers = [];
    for( let n of this.numbers.controls){
      this.lottoRooster.numbers.push(n.value);

    }
    this.homeService.addLottoRooster(this.lottoRooster).subscribe(e => this.getRoosters.next());
    this.roosterFillZeros();

  }
  onSubmit() { this.submitted = true; }


}
