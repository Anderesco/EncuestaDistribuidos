import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { ChartType } from 'chart.js';
import { MultiDataSet, Label } from 'ng2-charts';

@Component({
  selector: 'app-g-pie',
  templateUrl: './g-pie.component.html',
  styleUrls: ['./g-pie.component.css']
})
export class GPieComponent implements OnInit, OnChanges {

  @Input() nro_encuestados_ciclo:any[] = [];
  doughnutChartLabels: Label[] = [];
  doughnutChartData: MultiDataSet = [
    []
  ];
  doughnutChartType: ChartType = 'doughnut';

  private donutColors=[
    {
      backgroundColor: [
        'rgba(40, 116, 166, 1)',
        'rgba(191, 201, 202, 1)',
        'rgba(241, 148, 138, 1)',
        'rgba(187, 143, 206, 1)',
        'rgba(133, 193, 233, 1)',
        'rgba(115, 198, 182, 1)'
    ]
    }
  ];

  constructor() { }

  ngOnInit() {
  }

<<<<<<< HEAD
=======
  ngOnChanges(){
    //console.log("G-Barra OnChange");
    
    this.doughnutChartLabels = [];
    this.doughnutChartData = [];
    // let data = [];
    // console.log(data);
    
    for (let index = 0; index < this.nro_encuestados_ciclo.length; index++) {
      this.doughnutChartLabels.push(this.nro_encuestados_ciclo[index].ciclo)
      this.doughnutChartData.push(this.nro_encuestados_ciclo[index].total)
    }
    //this.doughnutChartData[0] = data;
    console.log(this.doughnutChartData);
    
  }

>>>>>>> branch_frontend
}
