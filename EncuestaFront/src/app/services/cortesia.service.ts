import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CortesiaService {

  constructor(private http: HttpClient) { }

  getEncuentadosPorCiclo(){
    const httpOptions = {
      headers: new HttpHeaders({ 
        'Access-Control-Allow-Origin':'*',
        'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
      })
    };
    
    return this.http.get('http://localhost:8080//alumno/ciclo', httpOptions);
  }

  getTotalEncuestados(){
    const httpOptions = {
      headers: new HttpHeaders({ 
        'Access-Control-Allow-Origin':'*',
        'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
      })
    };
    
    return this.http.get('http://localhost:8080//alumno/total', httpOptions);
  }

  getExpectativaPorPregunta(){
    const httpOptions = {
      headers: new HttpHeaders({ 
        'Access-Control-Allow-Origin':'*',
        'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
      })
    };
    return this.http.get('http://localhost:8080//alumno/espctativa/3', httpOptions);
  }

  getConformidadDimensionAnio(){
    const httpOptions = {
      headers: new HttpHeaders({ 
        'Access-Control-Allow-Origin':'*',
        'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
      })
    };
    return this.http.get('http://localhost:8080/alumno/reporte/3', httpOptions);
  }

  getPercepcionGeneral(){
    const httpOptions = {
      headers: new HttpHeaders({ 
        'Access-Control-Allow-Origin':'*',
        'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
      })
    };

    return this.http.get('http://localhost:8080/alumnoPregunta/Percepcion/3', httpOptions)

  }

  getExpectativaGeneral(){
    const httpOptions = {
      headers: new HttpHeaders({ 
        'Access-Control-Allow-Origin':'*',
        'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
      })
    };

    return this.http.get('http://localhost:8080/alumnoPregunta/Espectativa/3', httpOptions);
  }
}
