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

    if (this.expectativaPorPregunta.length > 0) {
      //console.log(this.expectativaPorPregunta);
      
      this.barChartLabels = [];
      let tempData: ChartDataSets[] = [];
      // this.barChartData[0].data = [];
      for (let i = 0; i < this.expectativaPorPregunta.length; i++) {
        this.barChartLabels.push("Preg. " + this.expectativaPorPregunta[i].id)
        for (let j = 0; j < this.expectativaPorPregunta[i].ciclos.length; j++) {
          if (tempData.length < this.expectativaPorPregunta[i].ciclos.length) {
            let label = this.expectativaPorPregunta[i].ciclos[j].ciclo;
            let data = [];
            for (let k = 0; k < this.expectativaPorPregunta.length; k++) {
              //console.log( (k+1) + " " + this.expectativaPorPregunta[k].ciclos[j].espectativaPostiva);
              //console.log("fdsfs " + this.expectativaPorPregunta[k].ciclos[j].espectativaPostiva);
              //console.log("k: " + k , " j: " + j + " length" + this.expectativaPorPregunta[k].ciclos.length);
              if (this.expectativaPorPregunta[k].ciclos.length > j) {
                if (this.expectativaPorPregunta[k].ciclos[j].ciclo != label) {
                  if (j>0) {
                    if (this.expectativaPorPregunta[k].ciclos[j-1].ciclo == label) {
                      data.push(this.expectativaPorPregunta[k].ciclos[j-1].espectativaPostiva)
                    }else{
                      data.push(0);
                    }
                  }
                }else{
                  data.push(this.expectativaPorPregunta[k].ciclos[j].espectativaPostiva)
                }
              }else{
                data.push(0);
              }
              
              
              
            }
            //console.log(data);
            
            tempData.push({data: data, label: "Ciclo " + label});
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

}
