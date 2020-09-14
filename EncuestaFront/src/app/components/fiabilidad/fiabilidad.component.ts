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

  constructor(private fiabilidadService:FiabilidadService) { }

  ngOnInit() {
    this.getEncuentadosPorCiclo();
    this.getTotalEncuestados();
    this.getExpectativaPorPregunta();
    this.getConformidadDimensionAnio();
  }

  getEncuentadosPorCiclo(){
    this.fiabilidadService.getEncuentadosPorCiclo()
        .subscribe((data: any[]) => {
          this.nro_encuestados_ciclo = data;
          //console.log(this.nro_encuestados_ciclo);
          
        });
  }

  getTotalEncuestados(){
    this.fiabilidadService.getTotalEncuestados()
        .subscribe((data: any[]) => {
          this.totalEncuestados = data[0].cantidadTotal;
          //console.log(this.totalEncuestados);
          
        });
  }

  getExpectativaPorPregunta(){
    this.fiabilidadService.getExpectativaPorPregunta()
        .subscribe((data: any[]) => {
          this.expectativaPorPregunta = data;
          //console.log(this.expectativaPorPregunta);
          
        });
  }

  getConformidadDimensionAnio(){
    this.fiabilidadService.getConformidadDimensionAnio()
        .subscribe((data: any[]) => {
          this.conformidadPorTangibilidad = data[0].listaConformidadAnioBean;
          //console.log(this.conformidadPorTangibilidad);
          
        });
  }

}
