import { Component, OnInit } from '@angular/core';
import { TangibilidadService } from '../../services/tangibilidad.service';

@Component({
  selector: 'app-tangibilidad',
  templateUrl: './tangibilidad.component.html',
  styleUrls: ['./tangibilidad.component.css']
})
export class TangibilidadComponent implements OnInit {

  nro_encuestados_ciclo:any[] = [];
  totalEncuestados:any[] = [];
  expectativaPorPregunta:any[] = [];
  conformidadPorTangibilidad:any[] = [];
  percepcionGeneral:any[] = [];
  expectativaGeneral:any[] = [];

  constructor(private tangibilidadService:TangibilidadService) { 
    
  }

  ngOnInit() {
    this.getEncuentadosPorCiclo();
    this.getTotalEncuestados();
    //this.getExpectativaPorPregunta();
    this.getConformidadDimensionAnio();
    this.getPercepcionGeneralService();
    this.getExpectativaGeneralService();
  }

  getEncuentadosPorCiclo(){
    this.tangibilidadService.getEncuentadosPorCiclo()
        .subscribe((data: any[]) => {
          this.nro_encuestados_ciclo = data;
        });
  }

  getTotalEncuestados(){
    this.tangibilidadService.getTotalEncuestados()
        .subscribe((data: any[]) => {
          this.totalEncuestados = data[0].cantidadTotal;
        });
  }

  getExpectativaPorPregunta(){
    this.tangibilidadService.getExpectativaPorPregunta()
        .subscribe((data: any[]) => {
          this.expectativaPorPregunta = data;
        });
  }

  getConformidadDimensionAnio(){
    this.tangibilidadService.getConformidadDimensionAnio()
        .subscribe((data: any[]) => {
          this.conformidadPorTangibilidad = data[0].listaConformidadAnioBean;
        });
  }

  getPercepcionGeneralService(){
    this.tangibilidadService.getPercepcionGeneral()
        .subscribe((data: any[]) => {
          this.percepcionGeneral = data;
        });
  }

  getExpectativaGeneralService(){
    this.tangibilidadService.getExpectativaGeneral()
        .subscribe((data: any[]) => {
          this.expectativaGeneral = data;
        });
  }

}
