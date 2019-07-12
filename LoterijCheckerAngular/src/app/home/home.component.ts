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
  constructor(private homeService: HomeService) {
   this.getRoosters();
    this.trekking = new Trekking();
  }

  ngOnInit() {
  }

  getRoosters(){
    this.homeService.getLottoRooster().subscribe(roosters => {this.roosters = roosters});

  }

  getLottoProfits(trekking: Trekking){
    this.homeService.getLottoProfits(trekking).subscribe(roosters => this.roosters = roosters);
  }

  deleteRooster(rooster:LottoRooster){
    this.homeService.deleteLottoRooster(rooster).subscribe(e => this.getRoosters());
  }

}
