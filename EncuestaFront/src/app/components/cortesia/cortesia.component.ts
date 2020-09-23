import { Component, OnInit } from '@angular/core';
import { CortesiaService } from '../../services/cortesia.service';

@Component({
  selector: 'app-cortesia',
  templateUrl: './cortesia.component.html',
  styleUrls: ['./cortesia.component.css']
})
export class CortesiaComponent implements OnInit {

  nro_encuestados_ciclo:any[] = [];
  totalEncuestados:any[] = [];
  expectativaPorPregunta:any[] = [];
  conformidadPorTangibilidad:any[] = [];
  percepcionGeneral:any[] = [];
  expectativaGeneral:any[] = [];

  constructor(private cortesiaService:CortesiaService) { }

  ngOnInit() {
    this.getEncuentadosPorCiclo();
    this.getTotalEncuestados();
    //this.getExpectativaPorPregunta();
    this.getConformidadDimensionAnio();
    this.getPercepcionGeneralService();
    this.getExpectativaGeneralService();
  }

  getEncuentadosPorCiclo(){
    this.cortesiaService.getEncuentadosPorCiclo()
        .subscribe((data: any[]) => {
          this.nro_encuestados_ciclo = data;
        });
  }

  getTotalEncuestados(){
    this.cortesiaService.getTotalEncuestados()
        .subscribe((data: any[]) => {
          this.totalEncuestados = data[0].cantidadTotal;
        });
  }

  getExpectativaPorPregunta(){
    this.cortesiaService.getExpectativaPorPregunta()
        .subscribe((data: any[]) => {
          this.expectativaPorPregunta = data;
        });
  }

  getConformidadDimensionAnio(){
    this.cortesiaService.getConformidadDimensionAnio()
        .subscribe((data: any[]) => {
          this.conformidadPorTangibilidad = data[0].listaConformidadAnioBean;
        });
  }

  getPercepcionGeneralService(){
    this.cortesiaService.getPercepcionGeneral()
        .subscribe((data: any[]) => {
          this.percepcionGeneral = data;
        });
  }

  getExpectativaGeneralService(){
    this.cortesiaService.getExpectativaGeneral()
        .subscribe((data: any[]) => {
          this.expectativaGeneral = data;
        });
  }

}
