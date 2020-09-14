import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label, Color } from 'ng2-charts';

@Component({
  selector: 'app-g-barra',
  templateUrl: './g-barra.component.html',
  styleUrls: ['./g-barra.component.css']
})
export class GBarraComponent implements OnInit, OnChanges {

  @Input() nro_encuestados_anio:any[] = [];

  barChartOptions: ChartOptions = {
    responsive: true,
    maintainAspectRatio: false
  };
  barChartLabels: Label[] = [];
  barChartType: ChartType = 'bar';
  barChartLegend = true;
  barChartPlugins = [];

  barChartData: ChartDataSets[] = [
    { data: [], label: 'Número de Alumnos' }
  ];

  barChartColors: Color[] = [
    { backgroundColor: 'rgba(100, 255, 100, 0.6)' },
  ]

  constructor() {     
    
  }

  ngOnInit() {
  }

  ngOnChanges(){
    console.log("G-Barra OnChange");
    
    this.barChartLabels = [];
    this.barChartData[0].data = [];
    for (let index = 0; index < this.nro_encuestados_anio.length; index++) {
      this.barChartLabels.push(this.nro_encuestados_anio[index].anio)
      this.barChartData[0].data.push(this.nro_encuestados_anio[index].cantidad)
    }
    
  }

}
