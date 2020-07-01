import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TiposFormComponent } from './tipos-form/tipos-form.component'
import { TiposListaComponent } from './tipos-lista/tipos-lista.component';

const routes: Routes = [
  { path: 'tipos-form' , component: TiposFormComponent },
  { path: 'tipos-form/:id' , component: TiposFormComponent },
  { path: 'tipos-lista', component: TiposListaComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TiposRoutingModule { }
