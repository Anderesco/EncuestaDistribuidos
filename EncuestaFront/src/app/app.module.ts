import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { HttpClientModule } from '@angular/common/http';

//Angular Material
import {MatToolbarModule} from '@angular/material/toolbar';
import { MatButtonModule } from "@angular/material/button";
import { MatIconModule } from "@angular/material/icon";
import {MatSidenavModule} from '@angular/material/sidenav'
import { MatCheckboxModule } from '@angular/material/checkbox';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material';
import {MatListModule} from '@angular/material/list';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatCardModule} from '@angular/material/card';
import {MatTableModule} from '@angular/material/table';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';

import { ChartsModule } from 'ng2-charts';

//Componentes
import { VistaGeneralComponent } from './components/vista-general/vista-general.component';
import { TangibilidadComponent } from './components/tangibilidad/tangibilidad.component';
import { FiabilidadComponent } from './components/fiabilidad/fiabilidad.component';
import { EmpatiaComponent } from './components/empatia/empatia.component';
import { CapRespuestaComponent } from './components/cap-respuesta/cap-respuesta.component';
import { CortesiaComponent } from './components/cortesia/cortesia.component';

//Rutas
import { APP_ROUTING } from './app.routes';
import { GBarraComponent } from './components/graficos/g-barra/g-barra.component';
import { GPieComponent } from './components/graficos/g-pie/g-pie.component';
import { GTablaComponent } from './components/graficos/g-tabla/g-tabla.component';
import { GTotalComponent } from './components/graficos/g-total/g-total.component';
import { GExpectativasBarComponent } from './components/graficos/g-expectativas-bar/g-expectativas-bar.component';
import { BarraExpectativaComponent } from './components/graficos/barra-expectativa/barra-expectativa.component';
import { BarraConformidadComponent } from './components/graficos/barra-conformidad/barra-conformidad.component';

@NgModule({
  declarations: [
    AppComponent,
    VistaGeneralComponent,
    TangibilidadComponent,
    FiabilidadComponent,
    EmpatiaComponent,
    CapRespuestaComponent,
    CortesiaComponent,
    GBarraComponent,
    GPieComponent,
    GTablaComponent,
    GTotalComponent,
    GExpectativasBarComponent,
    BarraExpectativaComponent,
    BarraConformidadComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatSidenavModule,
    FormsModule,
    ReactiveFormsModule,
    MatCheckboxModule,
    MatFormFieldModule,
    MatInputModule,
    MatListModule,
    APP_ROUTING,
    ChartsModule,
    MatGridListModule,
    MatCardModule,
    MatTableModule,
    HttpClientModule,
    MatProgressSpinnerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
