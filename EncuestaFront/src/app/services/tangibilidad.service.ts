import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TangibilidadService {

  private nro_encuestados_ciclo:any[] = [
    {
      "nomb_pregunta": "Pregunta 1",
      "ciclos": [
          {
              "nomb_ciclo": "Ciclo 6",
              "nro_alumnos_expectativa_positiva": 20
          },
          {
              "nomb_ciclo": "Ciclo 8",
              "nro_alumnos_expectativa_positiva": 20
          },
          {
              "nomb_ciclo": "Ciclo 9",
              "nro_alumnos_expectativa_positiva": 20
          }
      ]
  },
  {
      "nomb_pregunta": "Pregunta 2",
      "ciclos": [
          {
              "nomb_ciclo": "Ciclo 6",
              "nro_alumnos_expectativa_positiva": 20
          },
          {
              "nomb_ciclo": "Ciclo 8",
              "nro_alumnos_expectativa_positiva": 20
          },
          {
              "nomb_ciclo": "Ciclo 9",
              "nro_alumnos_expectativa_positiva": 20
          }
      ]
  }
  ];

  constructor(private http: HttpClient) { 
    console.log("Tangibilidad Service listo!!");
    
  }

  getEncuestadosPorCiclo(){
    return this.nro_encuestados_ciclo;
  }

  getServicioEjemplo(){
    this.http.get('https://restcountries.eu/rest/v2/lang/es')
          .subscribe(paises => {
            console.log(paises);
            
          });
  }
}
