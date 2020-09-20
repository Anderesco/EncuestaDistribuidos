import {RouterModule, Routes} from '@angular/router'
import { VistaGeneralComponent } from './components/vista-general/vista-general.component';
import { TangibilidadComponent } from './components/tangibilidad/tangibilidad.component';
import { FiabilidadComponent } from './components/fiabilidad/fiabilidad.component';
import { EmpatiaComponent } from './components/empatia/empatia.component';
import { CapRespuestaComponent } from './components/cap-respuesta/cap-respuesta.component';
import { CortesiaComponent } from './components/cortesia/cortesia.component';
import { VistaTablasComponent } from './components/vista-tablas/vista-tablas.component';
import { LoginComponent } from './components/login/login.component';
import { AuthGuard } from './shared/guard/auth.guard';

const APP_ROUTES: Routes = [
    
    {path: 'home', component: VistaGeneralComponent, canActivate: [AuthGuard]},
    {path: 'tangibilidad', component: TangibilidadComponent, canActivate: [AuthGuard]},
    {path: 'fiabilidad', component: FiabilidadComponent, canActivate: [AuthGuard]},
    {path: 'empatia', component: EmpatiaComponent, canActivate: [AuthGuard]},
    {path: 'caprespuesta', component: CapRespuestaComponent, canActivate: [AuthGuard]},
    {path: 'cortesia', component: CortesiaComponent, canActivate: [AuthGuard]},
    {path: 'tablas', component: VistaTablasComponent},
    {path: 'login', component: LoginComponent},
    {path: '**', pathMatch: 'full', redirectTo: 'home'}
];

export const APP_ROUTING = RouterModule.forRoot(APP_ROUTES);