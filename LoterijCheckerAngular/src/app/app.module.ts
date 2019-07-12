import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import {RouterModule, Routes} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import { LottoRoosterFormComponent } from './lotto-rooster-form/lotto-rooster-form.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { LottoTrekkingFormComponent } from './lotto-trekking-form/lotto-trekking-form.component';


const appRoutes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {path: 'home', component: HomeComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LottoRoosterFormComponent,
    LottoTrekkingFormComponent
  ],
  imports: [
    BrowserModule,HttpClientModule,FormsModule,ReactiveFormsModule,
    RouterModule.forRoot(
      appRoutes,
      {enableTracing: true}
    )
  ],
  providers: [AppComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
