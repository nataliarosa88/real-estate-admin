import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { ProprietariosRoutingModule } from './proprietarios-routing.module';
import { ProprietariosFormComponent } from './proprietarios-form/proprietarios-form.component';
import { ProprietariosListaComponent } from './proprietarios-lista/proprietarios-lista.component';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [ProprietariosFormComponent, ProprietariosListaComponent],
  imports: [
    CommonModule,
    ProprietariosRoutingModule,
    FormsModule,
    RouterModule,
    Ng2SearchPipeModule
  ], exports: [
    ProprietariosFormComponent,
    ProprietariosListaComponent
  ]
})
export class ProprietariosModule {

}
