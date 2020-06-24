import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { ProprietariosRoutingModule } from './proprietarios-routing.module';
import { ProprietariosFormComponent } from './proprietarios-form/proprietarios-form.component';
import { ProprietariosListaComponent } from './proprietarios-lista/proprietarios-lista.component';


@NgModule({
  declarations: [ProprietariosFormComponent, ProprietariosListaComponent],
  imports: [
    CommonModule,
    ProprietariosRoutingModule,
    FormsModule
  ], exports: [
    ProprietariosFormComponent
  ]
})
export class ProprietariosModule {

}
