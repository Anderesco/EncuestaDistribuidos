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

  constructor(private tangibilidadService:TangibilidadService) { 
    //console.log("Constructor Tangibilidad");
    
  }

  ngOnInit() {
    this.getEncuentadosPorCiclo();
    this.getTotalEncuestados();
    this.getExpectativaPorPregunta();
    this.getConformidadDimensionAnio();
  }

  getEncuentadosPorCiclo(){
    this.tangibilidadService.getEncuentadosPorCiclo()
        .subscribe((data: any[]) => {
          this.nro_encuestados_ciclo = data;
          //console.log(this.nro_encuestados_ciclo);
          
        });
  }

  getTotalEncuestados(){
    this.tangibilidadService.getTotalEncuestados()
        .subscribe((data: any[]) => {
          this.totalEncuestados = data[0].cantidadTotal;
          //console.log(this.totalEncuestados);
          
        });
  }

  getExpectativaPorPregunta(){
    this.tangibilidadService.getExpectativaPorPregunta()
        .subscribe((data: any[]) => {
          this.expectativaPorPregunta = data;
          //console.log(this.expectativaPorPregunta);
          
        });
  }

  getConformidadDimensionAnio(){
    this.tangibilidadService.getConformidadDimensionAnio()
        .subscribe((data: any[]) => {
          this.conformidadPorTangibilidad = data[0].listaConformidadAnioBean;
          //console.log(this.conformidadPorTangibilidad);
          
        });
  }

}
