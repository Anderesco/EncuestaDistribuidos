import { Component, OnInit } from '@angular/core';
import { FiabilidadService } from '../../services/fiabilidad.service';

@Component({
  selector: 'app-fiabilidad',
  templateUrl: './fiabilidad.component.html',
  styleUrls: ['./fiabilidad.component.css']
})
export class FiabilidadComponent implements OnInit {

  nro_encuestados_ciclo:any[] = [];
  totalEncuestados:any[] = [];
  expectativaPorPregunta:any[] = [];
  conformidadPorTangibilidad:any[] = [];
  percepcionGeneral:any[] = [];
  expectativaGeneral:any[] = [];

  constructor(private fiabilidadService:FiabilidadService) { }

  ngOnInit() {
    this.getEncuentadosPorCiclo();
    this.getTotalEncuestados();
    //this.getExpectativaPorPregunta();
    this.getConformidadDimensionAnio();
    this.getPercepcionGeneralService();
    this.getExpectativaGeneralService();
  }

  getEncuentadosPorCiclo(){
    this.fiabilidadService.getEncuentadosPorCiclo()
        .subscribe((data: any[]) => {
          this.nro_encuestados_ciclo = data;
        });
  }

  getTotalEncuestados(){
    this.fiabilidadService.getTotalEncuestados()
        .subscribe((data: any[]) => {
          this.totalEncuestados = data[0].cantidadTotal;
        });
  }

  getExpectativaPorPregunta(){
    this.fiabilidadService.getExpectativaPorPregunta()
        .subscribe((data: any[]) => {
          this.expectativaPorPregunta = data;
        });
  }

  getConformidadDimensionAnio(){
    this.fiabilidadService.getConformidadDimensionAnio()
        .subscribe((data: any[]) => {
          this.conformidadPorTangibilidad = data[0].listaConformidadAnioBean;
        });
  }

  getPercepcionGeneralService(){
    this.fiabilidadService.getPercepcionGeneral()
        .subscribe((data: any[]) => {
          this.percepcionGeneral = data;
        });
  }

  getExpectativaGeneralService(){
    this.fiabilidadService.getExpectativaGeneral()
        .subscribe((data: any[]) => {
          this.expectativaGeneral = data;
        });
  }

}
