import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from "rxjs";
import {LottoRooster} from "./lottoRooster";
import {LottoRoosterForm} from "../lotto-rooster-form/lottoRoosterForm";
import {observableToBeFn} from "rxjs/internal/testing/TestScheduler";
import {Trekking} from "./trekking";

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root',
})
export class HomeService {
  private lottoRoostersUrl = '/lotto/roosters';
  private trekkingUrl = '/lotto/trekking';

  constructor(private http: HttpClient) { }

  getLottoRooster(): Observable<LottoRooster[]>{
    return this.http.get<LottoRooster[]>(this.lottoRoostersUrl);
  }
  addLottoRooster(rooster: LottoRoosterForm) : Observable<LottoRoosterForm>{
    console.log('post lotto rooster');
    return this.http.post<LottoRoosterForm>(this.lottoRoostersUrl, rooster, httpOptions);
  }
  deleteLottoRooster(rooster: LottoRooster) : Observable<LottoRoosterForm>{
    const url = `${this.lottoRoostersUrl}/${rooster.id}`;
    return this.http.delete<LottoRoosterForm>(url);
  }
  getLottoProfits(trekking: Trekking) : Observable<LottoRooster[]>{
    let n = '[';
    let i = 0;
    let wv = '';
    let j = 0;
    for(let entry of trekking.winstVerdeling.entries()){
      if(j == 5){
        wv = wv + '"' + entry[0] + '":' + entry[1];
      }else {
        wv = wv + '"' + entry[0] + '":' + entry[1] + ',';
      }
      j++;
    }
    for(let number of trekking.numbers){
      if(i == 5){
        n = n + number + ']';
      }else {
        n = n + number + ',';
      }
      i++;
    }
    const bod = '{"winstVerdeling":{'+ wv +'},"numbers":'+ n+',"extraNumber":'+trekking.extraNumber+'}'
    return this.http.post<LottoRooster[]>(this.trekkingUrl, bod,httpOptions);
  }
}
