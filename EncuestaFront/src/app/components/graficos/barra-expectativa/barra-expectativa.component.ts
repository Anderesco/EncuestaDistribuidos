import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label } from 'ng2-charts';

@Component({
  selector: 'app-barra-expectativa',
  templateUrl: './barra-expectativa.component.html',
  styleUrls: ['./barra-expectativa.component.css']
})
export class BarraExpectativaComponent implements OnInit, OnChanges {

  @Input() expectativaPorPregunta:any[] = [];
  loading:Boolean = false;

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
  public barChartLabels: Label[] = [];
  public barChartType: ChartType = 'bar';
  public barChartLegend = true;
  public barChartPlugins = [];

  public barChartData: ChartDataSets[] = [
    { data: [], label: '' }
  ];


  constructor() { }

  ngOnInit() {
    this.loading = false;
  }

  ngOnChanges(){
    console.log("G-Barra OnChange");
    
    this.barChartLabels = [];
    let tempData: ChartDataSets[] = [];
    // this.barChartData[0].data = [];
    for (let i = 0; i < this.expectativaPorPregunta.length; i++) {
      this.barChartLabels.push("Preg. " + this.expectativaPorPregunta[i].id)
      for (let j = 0; j < this.expectativaPorPregunta[j].ciclos.length; j++) {
        if (tempData.length < this.expectativaPorPregunta[j].ciclos.length) {
          let label = this.expectativaPorPregunta[j].ciclos[j].ciclo;
          let data = [];
          for (let k = 0; k < this.expectativaPorPregunta.length; k++) {
            //console.log( (k+1) + " " + this.expectativaPorPregunta[k].ciclos[j].espectativaPostiva);
            data.push(this.expectativaPorPregunta[k].ciclos[j].espectativaPostiva)
          }
          tempData.push({data: data, label: label});
          // this.barChartData[j].label = this.expectativaPorPregunta[j].ciclos[j];
          //console.log(this.barChartData[j].label);
          
        }
        
      }
    }

    //console.log(tempData);
    //this.barChartLabels = [];
    this.barChartData =tempData;
    //console.log(this.barChartData);
    if (this.expectativaPorPregunta != []) {
      this.loading = true;
    }
    
    
  }

}
