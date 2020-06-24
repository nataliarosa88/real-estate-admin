import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { ImoveisRoutingModule } from './imoveis-routing.module';
import { ImoveisFormComponent } from './imoveis-form/imoveis-form.component';
import { ImoveisListaComponent } from './imoveis-lista/imoveis-lista.component';


@NgModule({
  declarations: [ImoveisFormComponent, ImoveisListaComponent],
  imports: [
    CommonModule,
    ImoveisRoutingModule,
    FormsModule
  ], exports: [
    ImoveisFormComponent
  ]
})
export class ImoveisModule {

}
