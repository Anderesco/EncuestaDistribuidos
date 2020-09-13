import { Component, OnInit } from '@angular/core';
import { EmpatiaService } from '../../services/empatia.service';

@Component({
  selector: 'app-empatia',
  templateUrl: './empatia.component.html',
  styleUrls: ['./empatia.component.css']
})
export class EmpatiaComponent implements OnInit {

  nro_encuestados_ciclo:any[] = [];
  totalEncuestados:any[] = [];
  expectativaPorPregunta:any[] = [];
  conformidadPorTangibilidad:any[] = [];

  constructor(private empatiaService:EmpatiaService) { }

  ngOnInit() {
    this.getEncuentadosPorCiclo();
    this.getTotalEncuestados();
    this.getExpectativaPorPregunta();
    this.getConformidadDimensionAnio();
  }

  getEncuentadosPorCiclo(){
    this.empatiaService.getEncuentadosPorCiclo()
        .subscribe((data: any[]) => {
          this.nro_encuestados_ciclo = data;
          // console.log(this.nro_encuestados_ciclo);
          
        });
  }

  getTotalEncuestados(){
    this.empatiaService.getTotalEncuestados()
        .subscribe((data: any[]) => {
          this.totalEncuestados = data[0].cantidadTotal;
          // console.log(this.totalEncuestados);
          
        });
  }

  getExpectativaPorPregunta(){
    this.empatiaService.getExpectativaPorPregunta()
        .subscribe((data: any[]) => {
          this.expectativaPorPregunta = data;
          //console.log(this.expectativaPorPregunta);
          
        });
  }

  getConformidadDimensionAnio(){
    this.empatiaService.getConformidadDimensionAnio()
        .subscribe((data: any[]) => {
          this.conformidadPorTangibilidad = data[0].listaConformidadAnioBean;
          //console.log(this.conformidadPorTangibilidad);
          
        });
  }

}
