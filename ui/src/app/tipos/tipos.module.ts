import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { TiposRoutingModule } from './tipos-routing.module';
import { TiposFormComponent } from './tipos-form/tipos-form.component';
import { TiposListaComponent } from './tipos-lista/tipos-lista.component';
import { RouterModule } from '@angular/router';
import { TextMaskModule } from 'angular2-text-mask';

@NgModule({
  declarations: [TiposFormComponent, TiposListaComponent],
  imports: [
    CommonModule,
    TiposRoutingModule,
    FormsModule,
    RouterModule,
    Ng2SearchPipeModule,
    TextMaskModule
  ], exports: [
    TiposFormComponent,
    TiposListaComponent
  ]
})
export class TiposModule {

}
