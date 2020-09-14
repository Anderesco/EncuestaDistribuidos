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

  constructor(private capRespuestaService:CapRespuestaService) { }

  ngOnInit() {
    this.getEncuentadosPorCiclo();
    this.getTotalEncuestados();
    this.getExpectativaPorPregunta();
    this.getConformidadDimensionAnio();
  }

  getEncuentadosPorCiclo(){
    this.capRespuestaService.getEncuentadosPorCiclo()
        .subscribe((data: any[]) => {
          this.nro_encuestados_ciclo = data;
          // console.log(this.nro_encuestados_ciclo);
          
        });
  }

  getTotalEncuestados(){
    this.capRespuestaService.getTotalEncuestados()
        .subscribe((data: any[]) => {
          this.totalEncuestados = data[0].cantidadTotal;
          // console.log(this.totalEncuestados);
          
        });
  }

  getExpectativaPorPregunta(){
    this.capRespuestaService.getExpectativaPorPregunta()
        .subscribe((data: any[]) => {
          this.expectativaPorPregunta = data;
          //console.log(this.expectativaPorPregunta);
          
        });
  }

  getConformidadDimensionAnio(){
    this.capRespuestaService.getConformidadDimensionAnio()
        .subscribe((data: any[]) => {
          this.conformidadPorTangibilidad = data[0].listaConformidadAnioBean;
          //console.log(this.conformidadPorTangibilidad);
          
        });
  }

}
