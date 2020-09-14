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

  constructor(private cortesiaService:CortesiaService) { }

  ngOnInit() {
    this.getEncuentadosPorCiclo();
    this.getTotalEncuestados();
    this.getExpectativaPorPregunta();
    this.getConformidadDimensionAnio();
  }

  getEncuentadosPorCiclo(){
    this.cortesiaService.getEncuentadosPorCiclo()
        .subscribe((data: any[]) => {
          this.nro_encuestados_ciclo = data;
          // console.log(this.nro_encuestados_ciclo);
          
        });
  }

  getTotalEncuestados(){
    this.cortesiaService.getTotalEncuestados()
        .subscribe((data: any[]) => {
          this.totalEncuestados = data[0].cantidadTotal;
          // console.log(this.totalEncuestados);
          
        });
  }

  getExpectativaPorPregunta(){
    this.cortesiaService.getExpectativaPorPregunta()
        .subscribe((data: any[]) => {
          this.expectativaPorPregunta = data;
          //console.log(this.expectativaPorPregunta);
          
        });
  }

  getConformidadDimensionAnio(){
    this.cortesiaService.getConformidadDimensionAnio()
        .subscribe((data: any[]) => {
          this.conformidadPorTangibilidad = data[0].listaConformidadAnioBean;
          //console.log(this.conformidadPorTangibilidad);
          
        });
  }

}
