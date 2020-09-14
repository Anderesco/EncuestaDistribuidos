import { Component, OnInit, Input, OnChanges } from '@angular/core';

export interface DimensionElement {
  nombreDimension: string;
  porcentaje: number;
}


// const DIMENSION_DATA: DimensionElement[] = [
//   {nombre: 'Tangibilidad', porcentaje: 58},
//   {nombre: 'Empatia', porcentaje: 30},
//   {nombre: 'Capacidad de Respuesta', porcentaje: 40},
//   {nombre: 'Fiabilidad', porcentaje: 45},
//   {nombre: 'Cortesía', porcentaje: 46}
// ];
const DIMENSION_DATA: DimensionElement[] = [];
/**
 * @title Basic use of `<table mat-table>`
 */

@Component({
  selector: 'app-g-tabla',
  templateUrl: './g-tabla.component.html',
  styleUrls: ['./g-tabla.component.css']
})
export class GTablaComponent implements OnInit, OnChanges {

  @Input() porcentajeDimiensiones:any[] = [];

  displayedColumns: string[] = ['nombreDimension', 'porcentaje'];
  dataSource = DIMENSION_DATA;

  constructor() { }

  ngOnInit() {
  }

  ngOnChanges(){
    
    this.dataSource = this.porcentajeDimiensiones;

  }

}
