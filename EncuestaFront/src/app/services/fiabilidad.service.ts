import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FiabilidadService {

  constructor(private http: HttpClient) { 
    console.log("Fiabilidad Service listo!!");
  }

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
    return this.http.get('http://localhost:8080//alumno/espctativa/1', httpOptions);
  }

  getConformidadDimensionAnio(){
    const httpOptions = {
      headers: new HttpHeaders({ 
        'Access-Control-Allow-Origin':'*',
        'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
      })
    };
    return this.http.get('http://localhost:8080/alumno/reporte/1', httpOptions);
  }
}
