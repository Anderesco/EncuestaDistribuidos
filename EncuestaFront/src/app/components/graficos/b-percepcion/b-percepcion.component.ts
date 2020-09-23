import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label } from 'ng2-charts';

@Component({
  selector: 'app-b-percepcion',
  templateUrl: './b-percepcion.component.html',
  styleUrls: ['./b-percepcion.component.css']
})
export class BPercepcionComponent implements OnInit, OnChanges {

  @Input() percepcionGeneral:any[] = [];
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
    if (this.percepcionGeneral.length != 0) {

      this.barChartLabels = [];
      this.barChartData[0].data = [];
      this.barChartData[1].data = [];
      this.barChartData[2].data = [];

      let positividad = [];
      let negatividad = [];
      let neutro = [];

      for (let i = 0; i < this.percepcionGeneral.length; i++) {
        this.barChartLabels.push('Pregunta ' + (i+1));
        positividad.push(this.percepcionGeneral[i].positividad);
        negatividad.push(this.percepcionGeneral[i].negatividad);
        neutro.push(this.percepcionGeneral[i].regular);
      }

      this.barChartData[0].data = positividad;
      this.barChartData[1].data = negatividad;
      this.barChartData[2].data = neutro;

      this.loading = true;
    }
  }

}
