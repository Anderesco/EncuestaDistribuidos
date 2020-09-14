import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label, Color } from 'ng2-charts';

@Component({
  selector: 'app-barra-conformidad',
  templateUrl: './barra-conformidad.component.html',
  styleUrls: ['./barra-conformidad.component.css']
})
export class BarraConformidadComponent implements OnInit, OnChanges {

  @Input() conformidadPorTangibilidad:any[] = [];

  barChartOptions: ChartOptions = {
    responsive: true,
    maintainAspectRatio: false
  };
  barChartLabels: Label[] = [];
  barChartType: ChartType = 'horizontalBar';
  barChartLegend = true;
  barChartPlugins = [];

  barChartData: ChartDataSets[] = [
    { data: [], label: 'Número de Alumnos' }
  ];

  barChartColors: Color[] = [
    { backgroundColor: 'rgba(100, 255, 100, 0.6)' },
  ]

  constructor() { }

  ngOnInit() {
  }

  ngOnChanges(){
    this.barChartLabels = [];
    this.barChartData[0].data = [];
    for (let i = 0; i < this.conformidadPorTangibilidad.length; i++) {
      this.barChartLabels.push(this.conformidadPorTangibilidad[i].anio);
      this.barChartData[0].data.push(this.conformidadPorTangibilidad[i].espectativaPositiva);
    }
  }

}
