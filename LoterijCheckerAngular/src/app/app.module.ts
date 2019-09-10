import { BrowserModule } from '@angular/platform-browser';
import {Injectable, NgModule} from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import {RouterModule, Routes} from "@angular/router";
import {HTTP_INTERCEPTORS, HttpClientModule, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import { LottoRoosterFormComponent } from './lotto-rooster-form/lotto-rooster-form.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { LottoTrekkingFormComponent } from './lotto-trekking-form/lotto-trekking-form.component';
import { LoginComponent } from './login/login.component';

@Injectable()
export class XhrInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const xhr = req.clone({
      headers: req.headers.set('X-Requested-With', 'XMLHttpRequest')
    });
    return next.handle(xhr);
  }
}

const appRoutes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  {path: 'home', component: HomeComponent},
  { path: 'login', component: LoginComponent},
  {path: 'error', redirectTo:'login', pathMatch:'full'}
];
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LottoRoosterFormComponent,
    LottoTrekkingFormComponent,
    LoginComponent
],
  imports: [
    BrowserModule,HttpClientModule,FormsModule,ReactiveFormsModule,
    RouterModule.forRoot(
      appRoutes,
      {useHash: true}
    )
  ],
  providers: [AppComponent, { provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }

