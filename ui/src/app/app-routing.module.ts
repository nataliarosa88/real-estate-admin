import { RegisterComponent } from './register/register.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router'
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { ProprietariosListaComponent } from './proprietarios/proprietarios-lista/proprietarios-lista.component';
import { ImoveisListaComponent } from './imoveis/imoveis-lista/imoveis-lista.component';
import { ClientesListaComponent } from './clientes/clientes-lista/clientes-lista.component';
import { TiposListaComponent } from './tipos/tipos-lista/tipos-lista.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './_services/auth_guard.service';

const routes: Routes = [
  { path : 'home', component: HomeComponent, canActivate: [AuthGuard]  },
  { path : 'imoveis-lista', component: ImoveisListaComponent, canActivate: [AuthGuard]  },
  { path : 'clientes-lista', component: ClientesListaComponent, canActivate: [AuthGuard]  },
  { path : 'proprietarios-lista', component: ProprietariosListaComponent, canActivate: [AuthGuard]  },
  { path : 'tipos-lista', component: TiposListaComponent, canActivate: [AuthGuard]  },
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
