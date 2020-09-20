import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label } from 'ng2-charts';

@Component({
  selector: 'app-b-expectativa',
  templateUrl: './b-expectativa.component.html',
  styleUrls: ['./b-expectativa.component.css']
})
export class BExpectativaComponent implements OnInit {

  public barChartOptions: ChartOptions = {
    responsive: true,
    maintainAspectRatio: false
  };
  //public barChartLabels: Label[] = ['Capacidad de Respuesta', 'Elementos Tangibles', 'Empatía', 'Expectativa de Fiabilidad', 'Seguridad'];
  public barChartLabels: Label[] = ['Pregunta 1', 'Pregunta 1', 'Pregunta 1', 'Pregunta 1', 'Pregunta 1', 'Pregunta 1', 'Pregunta 1'];
  public barChartType: ChartType = 'bar';
  public barChartLegend = true;
  public barChartPlugins = [];

  public barChartData: ChartDataSets[] = [
    { data: [65, 59, 80, 81, 56, 55, 40], label: 'Positivo' },
    { data: [28, 48, 40, 19, 86, 27, 90], label: 'Negativo' }
  ];

  constructor() { }

  ngOnInit() {
  }

}
