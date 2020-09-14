import { Component, OnInit, Input, OnChanges } from '@angular/core';

@Component({
  selector: 'app-g-total',
  templateUrl: './g-total.component.html',
  styleUrls: ['./g-total.component.css']
})
export class GTotalComponent implements OnInit {

  @Input() totalEncuestados: number = null;

  constructor() { }

  ngOnInit() {
  }

}
