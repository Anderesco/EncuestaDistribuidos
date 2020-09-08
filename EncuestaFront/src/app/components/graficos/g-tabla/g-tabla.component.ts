import { Component, OnInit } from '@angular/core';

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

export interface DimensionElement {
  nombre: string;
  porcentaje: number;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
  {position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be'},
  {position: 5, name: 'Boron', weight: 10.811, symbol: 'B'},
  {position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C'}
];


const DIMENSION_DATA: DimensionElement[] = [
  {nombre: 'Tangibilidad', porcentaje: 58},
  {nombre: 'Empatia', porcentaje: 30},
  {nombre: 'Capacidad de Respuesta', porcentaje: 40},
  {nombre: 'Fiabilidad', porcentaje: 45},
  {nombre: 'Cortesía', porcentaje: 46}
];
/**
 * @title Basic use of `<table mat-table>`
 */

@Component({
  selector: 'app-g-tabla',
  templateUrl: './g-tabla.component.html',
  styleUrls: ['./g-tabla.component.css']
})
export class GTablaComponent implements OnInit {

  displayedColumns: string[] = ['nombre', 'porcentaje'];
  dataSource = DIMENSION_DATA;

  constructor() { }

  ngOnInit() {
  }

}
