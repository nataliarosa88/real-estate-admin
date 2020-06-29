import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { ImoveisRoutingModule } from './imoveis-routing.module';
import { ImoveisFormComponent } from './imoveis-form/imoveis-form.component';
import { ImoveisListaComponent } from './imoveis-lista/imoveis-lista.component';
import { RouterModule } from '@angular/router';
import { TextMaskModule } from 'angular2-text-mask';

@NgModule({
  declarations: [ImoveisFormComponent, ImoveisListaComponent],
  imports: [
    CommonModule,
    ImoveisRoutingModule,
    FormsModule,
    RouterModule,
    Ng2SearchPipeModule,
    TextMaskModule
  ], exports: [
    ImoveisFormComponent,
    ImoveisListaComponent
  ]
})
export class ImoveisModule {

}
