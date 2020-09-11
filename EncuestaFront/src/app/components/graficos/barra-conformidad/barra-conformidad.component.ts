import { Component, OnInit } from '@angular/core';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label, Color } from 'ng2-charts';

@Component({
  selector: 'app-barra-conformidad',
  templateUrl: './barra-conformidad.component.html',
  styleUrls: ['./barra-conformidad.component.css']
})
export class BarraConformidadComponent implements OnInit {

  barChartOptions: ChartOptions = {
    responsive: true,
    maintainAspectRatio: false
  };
  barChartLabels: Label[] = ['2013', '2014', '2015', '2016', '2017', '2018'];
  barChartType: ChartType = 'horizontalBar';
  barChartLegend = true;
  barChartPlugins = [];

  barChartData: ChartDataSets[] = [
    { data: [45, 37, 60, 70, 46, 33], label: 'Número de Alumnos' }
  ];

  barChartColors: Color[] = [
    { backgroundColor: 'rgba(100, 255, 100, 0.6)' },
  ]

  constructor() { }

  ngOnInit() {
  }

}
