import { Component, OnInit, OnChanges, AfterContentInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import { Observable } from 'rxjs';
import { AuthService } from './services/auth.service';
import { Router, NavigationStart } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'frontendDAD';
  isLoggedIn$: Observable<boolean>;
  isLoggedIn:boolean;
  options: FormGroup;
  durationInSeconds = 3;
  nombres = '';
  apellidoPaterno = '';

  constructor(fb: FormBuilder, private authService: AuthService, private router: Router) {
    this.options = fb.group({
      bottom: 0,
      fixed: false,
      top: 0
    });
  }

  ngOnInit() {
    this.authService.isLoggedIn.subscribe(value => {
      this.isLoggedIn = value;
      let retrievedObject = JSON.parse(localStorage.getItem('user'));
      if (retrievedObject != null) {
        // console.log(retrievedObject);
        this.nombres = retrievedObject.nombres;
        this.apellidoPaterno = retrievedObject.apelidoPaterno;
      }
      
    });
    this.router.events.subscribe(event =>{
      if (event instanceof NavigationStart){
        if (event.url == "/login" && this.isLoggedIn) {
          console.log("El usuario se encuentra logueado!!!!");
          this.router.navigate(['/home']);
        }
        
      }
   })
    //console.log(this.isLoggedIn$);
    //console.log(this.router.url);
    
  }

  onLogout() {
    this.authService.logout();
  }

}
