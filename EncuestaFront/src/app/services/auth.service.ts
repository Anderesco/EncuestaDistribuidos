import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { User } from '../shared/guard/user';

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

  constructor(
    private router: Router
  ) {
    // this.loggedIn.next(true);
  }

  login(user: User) {
    if (user.userName !== '' && user.password !== '' ) {
      this.loggedIn.next(true);
      this.router.navigate(['/']);
      localStorage.setItem('user', JSON.stringify(user));
    }
  }

  logout() {
    localStorage.removeItem('user');
    this.loggedIn.next(false);
    this.router.navigate(['/login']);
  }
}