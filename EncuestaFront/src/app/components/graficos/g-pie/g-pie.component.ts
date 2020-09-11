import { Component, OnInit } from '@angular/core';
import { ChartType } from 'chart.js';
import { MultiDataSet, Label } from 'ng2-charts';

@Component({
  selector: 'app-g-pie',
  templateUrl: './g-pie.component.html',
  styleUrls: ['./g-pie.component.css']
})
export class GPieComponent implements OnInit {

  doughnutChartLabels: Label[] = ['6to Ciclo', '7mo Ciclo', '8vo Ciclo', '9no Ciclo', '10mo Ciclo'];
  doughnutChartData: MultiDataSet = [
    [45, 30, 25, 10, 10]
  ];
  doughnutChartType: ChartType = 'doughnut';

  constructor() { }

  ngOnInit() {
  }

}
