import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProprietariosFormComponent } from './proprietarios-form/proprietarios-form.component'
import { ProprietariosListaComponent } from './proprietarios-lista/proprietarios-lista.component';

const routes: Routes = [
  { path: 'proprietarios-form' , component: ProprietariosFormComponent },
  { path: 'proprietarios-form/:id' , component: ProprietariosFormComponent },
  { path: 'proprietarios-lista', component: ProprietariosListaComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProprietariosRoutingModule { }
