import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label } from 'ng2-charts';

@Component({
  selector: 'app-b-expectativa',
  templateUrl: './b-expectativa.component.html',
  styleUrls: ['./b-expectativa.component.css']
})
export class BExpectativaComponent implements OnInit, OnChanges {

  @Input() expectativaGeneral:any[] = [];
  loading:Boolean = false;

  public barChartOptions: ChartOptions = {
    responsive: true,
    maintainAspectRatio: false
  };
  
  public barChartLabels: Label[] = ['Pregunta 1', 'Pregunta 1', 'Pregunta 1', 'Pregunta 1', 'Pregunta 1', 'Pregunta 1', 'Pregunta 1'];
  public barChartType: ChartType = 'bar';
  public barChartLegend = true;
  public barChartPlugins = [];

  public barChartData: ChartDataSets[] = [
    { data: [65, 59, 80, 81, 56, 55, 40], label: 'Positivo' },
    { data: [28, 48, 40, 19, 86, 27, 90], label: 'Negativo' },
    { data: [45, 8, 6, 87, 90, 9, 89], label: 'Neutro' }
  ];

  constructor() { }

  ngOnInit() {
  }

  ngOnChanges(){
    if (this.expectativaGeneral.length != 0) {
      
      this.barChartLabels = [];
      this.barChartData[0].data = [];
      this.barChartData[1].data = [];
      this.barChartData[2].data = [];

      let positividad = [];
      let negatividad = [];
      let neutro = [];

      for (let i = 0; i < this.expectativaGeneral.length; i++) {
        this.barChartLabels.push('Pregunta ' + this.expectativaGeneral[i].pregunta);
        positividad.push(this.expectativaGeneral[i].positividad);
        negatividad.push(this.expectativaGeneral[i].negatividad);
        neutro.push(this.expectativaGeneral[i].regular);
      }

      this.barChartData[0].data = positividad;
      this.barChartData[1].data = negatividad;
      this.barChartData[2].data = neutro;

      this.loading = true;
    }
  }

}
