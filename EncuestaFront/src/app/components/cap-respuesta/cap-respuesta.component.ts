import { Component, OnInit } from '@angular/core';
import { CapRespuestaService } from '../../services/cap-respuesta.service';

@Component({
  selector: 'app-cap-respuesta',
  templateUrl: './cap-respuesta.component.html',
  styleUrls: ['./cap-respuesta.component.css']
})
export class CapRespuestaComponent implements OnInit {

  nro_encuestados_ciclo:any[] = [];
  totalEncuestados:any[] = [];
  expectativaPorPregunta:any[] = [];
  conformidadPorTangibilidad:any[] = [];
  percepcionGeneral:any[] = [];
  expectativaGeneral:any[] = [];

  constructor(private capRespuestaService:CapRespuestaService) { }

  ngOnInit() {
    this.getEncuentadosPorCiclo();
    this.getTotalEncuestados();
    //this.getExpectativaPorPregunta();
    this.getConformidadDimensionAnio();
    this.getPercepcionGeneralService();
    this.getExpectativaGeneralService();
  }

  getEncuentadosPorCiclo(){
    this.capRespuestaService.getEncuentadosPorCiclo()
        .subscribe((data: any[]) => {
          this.nro_encuestados_ciclo = data; 
        });
  }

  getTotalEncuestados(){
    this.capRespuestaService.getTotalEncuestados()
        .subscribe((data: any[]) => {
          this.totalEncuestados = data[0].cantidadTotal;
        });
  }

  getExpectativaPorPregunta(){
    this.capRespuestaService.getExpectativaPorPregunta()
        .subscribe((data: any[]) => {
          this.expectativaPorPregunta = data;
        });
  }

  getConformidadDimensionAnio(){
    this.capRespuestaService.getConformidadDimensionAnio()
        .subscribe((data: any[]) => {
          this.conformidadPorTangibilidad = data[0].listaConformidadAnioBean;
        });
  }

  getPercepcionGeneralService(){
    this.capRespuestaService.getPercepcionGeneral()
        .subscribe((data: any[]) => {
          this.percepcionGeneral = data;
        });
  }

  getExpectativaGeneralService(){
    this.capRespuestaService.getExpectativaGeneral()
        .subscribe((data: any[]) => {
          this.expectativaGeneral = data;
        });
  }

}
