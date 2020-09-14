import { Component, OnInit, OnChanges } from '@angular/core';
import { GeneralService } from '../../services/general.service';

@Component({
  selector: 'app-vista-general',
  templateUrl: './vista-general.component.html',
  styleUrls: ['./vista-general.component.css']
})
export class VistaGeneralComponent implements OnInit {

  nro_encuestados_anio:any[] = [];
  nro_encuestados_ciclo:any[] = [];
  totalEncuestados:number = null;
  porcentajeDimiensiones:any[] = [];

  constructor(private _generalService:GeneralService) { 
    //console.log("Constructor");
    
  }

  ngOnInit() {
    this.getEncuestadosPorAnio();
    this.getEncuentadosPorCiclo();
    this.getTotalEncuestados();
    this.getIndicadoresDimensiones();
  }

  getEncuestadosPorAnio(){
    this._generalService.getEncuentadosPorAnio()
        .subscribe((data: any[]) => {
          this.nro_encuestados_anio = data;
          //console.log(this.nro_encuestados_anio);
          
        });
  }

  getEncuentadosPorCiclo(){
    this._generalService.getEncuentadosPorCiclo()
        .subscribe((data: any[]) => {
          this.nro_encuestados_ciclo = data;
          //console.log(this.nro_encuestados_ciclo);
          
        });
  }

  getTotalEncuestados(){
    this._generalService.getTotalEncuestados()
        .subscribe((data: any[]) => {
          this.totalEncuestados = data[0].cantidadTotal;
          //console.log(this.totalEncuestados);
          
        });
  }

  getIndicadoresDimensiones(){
    this._generalService.getIndicadoresDimensiones()
        .subscribe((data: any[]) => {
          this.porcentajeDimiensiones = data;
          console.log(this.porcentajeDimiensiones);
          
        });
  }

}
