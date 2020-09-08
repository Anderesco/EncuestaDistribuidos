import { Component, OnInit } from '@angular/core';
import { TangibilidadService } from '../../services/tangibilidad.service';

@Component({
  selector: 'app-tangibilidad',
  templateUrl: './tangibilidad.component.html',
  styleUrls: ['./tangibilidad.component.css']
})
export class TangibilidadComponent implements OnInit {

  nro_encuestados_ciclo:any[] = [];

  constructor(private _tangibilidadService:TangibilidadService) { 
    //console.log("Constructor Tangibilidad");
    
  }

  ngOnInit() {
    //console.log("OnInit");
    this.nro_encuestados_ciclo = this._tangibilidadService.getEncuestadosPorCiclo();
    console.log(this.nro_encuestados_ciclo);
    
  }

}
