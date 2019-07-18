import { Component, OnInit } from '@angular/core';
import {HomeService} from "./home.service";
import {LottoRooster} from "./lottoRooster";
import {Trekking} from "./trekking";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  roosters: LottoRooster[];
  trekking: Trekking;
  totalProfit: number;
  constructor(private homeService: HomeService) {
   this.getRoosters();
    this.trekking = new Trekking();
    this.totalProfit = 0;
  }

  ngOnInit() {
  }

  getRoosters(){
    this.homeService.getLottoRooster().subscribe(roosters => {this.roosters = roosters; this.totalProfit = 0;this.trekking = new Trekking();});

  }

  getLottoProfits(trekking: Trekking){
    this.homeService.getLottoProfits(trekking).subscribe(roosters => {
      this.roosters = roosters;
      this.totalProfit = 0;
      this.trekking = trekking;
      for (let ro of this.roosters){
        this.totalProfit = this.totalProfit + ro.winnings;
      }
     });
  }
  checkNumber(n: number): any{
    let isInTrekking = false;
    if(this.trekking.numbers.length != 0){
      for(let roosterN of this.trekking.numbers){
        if(roosterN == n){
          isInTrekking = true;
          break;
        }
      }
    }
    return isInTrekking;
}
checkExtraNumber(n:number):any{
  let isInTrekking = false;
  if(this.trekking.numbers.length != 0){
    if(n == this.trekking.extraNumber){
      isInTrekking = true;
    }

  }
  return isInTrekking;
}

  deleteRooster(rooster:LottoRooster){
    this.homeService.deleteLottoRooster(rooster).subscribe(e => this.getRoosters());
  }

}
