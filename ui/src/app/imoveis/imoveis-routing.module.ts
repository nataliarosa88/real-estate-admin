import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ImoveisFormComponent } from './imoveis-form/imoveis-form.component'
import { ImoveisListaComponent } from './imoveis-lista/imoveis-lista.component';

const routes: Routes = [
  { path: 'imoveis-form' , component: ImoveisFormComponent },
  { path: 'imoveis-form/:id' , component: ImoveisFormComponent },
  { path: 'imoveis-lista', component: ImoveisListaComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ImoveisRoutingModule { }
