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
  percepcionGeneral:any[] = [];
  expectativaGeneral:any[] = [];

  constructor(private empatiaService:EmpatiaService) { }

  ngOnInit() {
    this.getEncuentadosPorCiclo();
    this.getTotalEncuestados();
    //this.getExpectativaPorPregunta();
    this.getConformidadDimensionAnio();
    this.getPercepcionGeneralService();
    this.getExpectativaGeneralService();
  }

  getEncuentadosPorCiclo(){
    this.empatiaService.getEncuentadosPorCiclo()
        .subscribe((data: any[]) => {
          this.nro_encuestados_ciclo = data; 
        });
  }

  getTotalEncuestados(){
    this.empatiaService.getTotalEncuestados()
        .subscribe((data: any[]) => {
          this.totalEncuestados = data[0].cantidadTotal;
        });
  }

  getExpectativaPorPregunta(){
    this.empatiaService.getExpectativaPorPregunta()
        .subscribe((data: any[]) => {
          this.expectativaPorPregunta = data; 
        });
  }

  getConformidadDimensionAnio(){
    this.empatiaService.getConformidadDimensionAnio()
        .subscribe((data: any[]) => {
          this.conformidadPorTangibilidad = data[0].listaConformidadAnioBean; 
        });
  }

  getPercepcionGeneralService(){
    this.empatiaService.getPercepcionGeneral()
        .subscribe((data: any[]) => {
          this.percepcionGeneral = data;
        });
  }

  getExpectativaGeneralService(){
    this.empatiaService.getExpectativaGeneral()
        .subscribe((data: any[]) => {
          this.expectativaGeneral = data;
        });
  }

}
