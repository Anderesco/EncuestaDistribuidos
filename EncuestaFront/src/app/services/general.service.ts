import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GeneralService {

  nro_encuestados_anio:any[] = [];

  constructor(private http: HttpClient) {
    console.log("General Service listo!!");
  }

  getEncuentadosPorAnio(){
    const httpOptions = {
      headers: new HttpHeaders({ 
        'Access-Control-Allow-Origin':'*',
        'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
      })
    };
    
    return this.http.get('http://localhost:8080/alumno/anio', httpOptions);
  }

  getEncuentadosPorCiclo(){
    const httpOptions = {
      headers: new HttpHeaders({ 
        'Access-Control-Allow-Origin':'*',
        'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
      })
    };
    
    return this.http.get('http://localhost:8080/alumno/ciclo', httpOptions);
  }

  getTotalEncuestados(){
    const httpOptions = {
      headers: new HttpHeaders({ 
        'Access-Control-Allow-Origin':'*',
        'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
      })
    };
    
    return this.http.get('http://localhost:8080/alumno/total', httpOptions);
  }

  getIndicadoresDimensiones(){
    const httpOptions = {
      headers: new HttpHeaders({ 
        'Access-Control-Allow-Origin':'*',
        'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
      })
    };
    
    return this.http.get('http://localhost:8080/alumno/positividad', httpOptions);
  }
}
