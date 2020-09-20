import { Component } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import { Observable } from 'rxjs';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontendDAD';
  isLoggedIn$: Observable<boolean>;
  isLoggedIn:boolean;
  options: FormGroup;

  constructor(fb: FormBuilder, private authService: AuthService) {
    this.options = fb.group({
      bottom: 0,
      fixed: false,
      top: 0
    });
  }

  ngOnInit() {
    this.authService.isLoggedIn.subscribe(value => {
      this.isLoggedIn = value;
      
    });
    //console.log(this.isLoggedIn$);
    
  }

}
