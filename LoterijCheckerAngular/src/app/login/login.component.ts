import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import {AppService} from '../app.service';


@Component({
  templateUrl: './login.component.html'
})
export class LoginComponent {

  credentials = {username: '', password: ''};

  constructor(private app: AppService, private http: HttpClient, private router: Router) {
    this.app.authenticate(undefined,() => {router.navigateByUrl('/home')});
  }

  login() {
    this.app.authenticate(this.credentials, () => {
      this.router.navigateByUrl('/home');
    });
    return false;
  }

}
