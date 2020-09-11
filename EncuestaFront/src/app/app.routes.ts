import {RouterModule, Routes} from '@angular/router'
import { VistaGeneralComponent } from './components/vista-general/vista-general.component';
import { TangibilidadComponent } from './components/tangibilidad/tangibilidad.component';
import { FiabilidadComponent } from './components/fiabilidad/fiabilidad.component';
import { EmpatiaComponent } from './components/empatia/empatia.component';
import { CapRespuestaComponent } from './components/cap-respuesta/cap-respuesta.component';
import { CortesiaComponent } from './components/cortesia/cortesia.component';

const APP_ROUTES: Routes = [
    {path: 'home', component: VistaGeneralComponent},
    {path: 'tangibilidad', component: TangibilidadComponent},
    {path: 'fiabilidad', component: FiabilidadComponent},
    {path: 'empatia', component: EmpatiaComponent},
    {path: 'caprespuesta', component: CapRespuestaComponent},
    {path: 'cortesia', component: CortesiaComponent},
    {path: '**', pathMatch: 'full', redirectTo: 'home'}
];

export const APP_ROUTING = RouterModule.forRoot(APP_ROUTES);