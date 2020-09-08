import { Component, OnInit } from '@angular/core';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label } from 'ng2-charts';

@Component({
  selector: 'app-barra-expectativa',
  templateUrl: './barra-expectativa.component.html',
  styleUrls: ['./barra-expectativa.component.css']
})
export class BarraExpectativaComponent implements OnInit {

  public barChartOptions: ChartOptions = {
    responsive: true,
    maintainAspectRatio: false,
    scales: {
       xAxes: [{
         stacked: true
        }],
       yAxes: [{
         stacked: true
        }]
    },
    legend: {
        display: true,
        position: 'bottom'
      }
  };
  public barChartLabels: Label[] = ['Pregunta 1', 'Pregunta 2', 'Pregunta 3', 'Pregunta 4', 'Pregunta 5', 'Pregunta 6', 'Pregunta 7'];
  public barChartType: ChartType = 'bar';
  public barChartLegend = true;
  public barChartPlugins = [];

  public barChartData: ChartDataSets[] = [
    { data: [65, 59, 80, 81, 56, 55, 40], label: 'Ciclo 6' },
    { data: [28, 48, 40, 19, 86, 27, 90], label: 'Ciclo 7' },
    { data: [65, 59, 80, 81, 56, 55, 40], label: 'Ciclo 8' },
    { data: [65, 59, 80, 81, 56, 55, 40], label: 'Ciclo 9' },
    { data: [65, 59, 80, 81, 56, 55, 40], label: 'Ciclo 10' },
  ];


  constructor() { }

  ngOnInit() {
  }

}
