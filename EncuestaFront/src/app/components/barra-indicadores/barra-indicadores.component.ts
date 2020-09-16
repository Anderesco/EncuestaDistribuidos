import { Component, OnInit, Input, OnChanges} from '@angular/core';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label } from 'ng2-charts';

@Component({
  selector: 'app-barra-indicadores',
  templateUrl: './barra-indicadores.component.html',
  styleUrls: ['./barra-indicadores.component.css']
})
export class BarraIndicadoresComponent implements OnInit, OnChanges {

  @Input() porcentajeDimiensiones:any[] = [];

  public barChartOptions: ChartOptions = {
    responsive: true,
    maintainAspectRatio: false
  };
  //public barChartLabels: Label[] = ['Capacidad de Respuesta', 'Elementos Tangibles', 'Empatía', 'Expectativa de Fiabilidad', 'Seguridad'];
  public barChartLabels: Label[] = [];
  public barChartType: ChartType = 'horizontalBar';
  public barChartLegend = true;
  public barChartPlugins = [];

  public barChartData: ChartDataSets[] = [
    { data: [65, 59, 80, 81, 56, 55, 40], label: 'Expectativa' },
    { data: [28, 48, 40, 19, 86, 27, 90], label: 'Percepción' }
  ];

  constructor() { }

  ngOnInit() {
  }

  ngOnChanges(){
    console.log("G-Barra OnChange");

    if (this.porcentajeDimiensiones.length > 0) {
      this.barChartLabels = [];
      //let dataExpectativa = [];
      //console.log(this.barChartData);
      //let dataExpectativa = [];
      this.barChartData[0].data = [];
      this.barChartData[1].data = [];
      for (let index = 0; index < this.porcentajeDimiensiones.length; index++) {
        this.barChartLabels.push(this.porcentajeDimiensiones[index].nombreDimension);
        //dataExpectativa[index].push("9")
        this.barChartData[0].data.push(this.porcentajeDimiensiones[index].espectativa*100);
        this.barChartData[1].data.push(this.porcentajeDimiensiones[index].percepcion*100);
        //onsole.log(this.porcentajeDimiensiones[index].espectativa);
        
      }

      //console.log(dataExpectativa);
    }
    
    
    
    
  }

}
