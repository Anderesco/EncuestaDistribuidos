import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { User } from '../shared/guard/user';
import { UserResponse } from '../shared/guard/userResponse';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class AuthService {
  private loggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  get isLoggedIn() {
    let retrievedObject = localStorage.getItem('user');
    console.log("isLoggedIn: " + JSON.parse(retrievedObject));
    if (retrievedObject != null) {
      this.loggedIn.next(true);
    }
    return this.loggedIn.asObservable();
  }

  public setLoggedIn(user: UserResponse){
    localStorage.setItem('user', JSON.stringify(user));
    this.loggedIn.next(true);
    this.router.navigate(['/']);
  }

  constructor(
    private router: Router,
    private http: HttpClient
  ) {
    // this.loggedIn.next(true);
  }

  login(user: User) {

    const httpOptions = {
      headers: new HttpHeaders({ 
        'Access-Control-Allow-Origin':'*',
        'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
      })
    };

    if (user.userName !== '' && user.password !== '' ) {
      return this.http.post('http://localhost:8080/login?usuario='+user.userName+'&contrasenia='+user.password +'', null, httpOptions);
    }
  }


  logout() {
    localStorage.removeItem('user');
    this.loggedIn.next(false);
    this.router.navigate(['/login']);
  }
}