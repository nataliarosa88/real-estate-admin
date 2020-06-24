import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { TemplateModule } from './template/template.module';
import { HomeComponent } from './home/home.component';
import { ClientesModule } from './clientes/clientes.module';
import { ClientesService } from './clientes.service';
import { ImoveisModule } from './imoveis/imoveis.module';
import { ImoveisService } from './imoveis.service';
import { ProprietariosModule } from './proprietarios/proprietarios.module';
import { ProprietariosService } from './proprietarios.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    TemplateModule,
    ProprietariosModule,
    ImoveisModule,
    ClientesModule,
    HttpClientModule
  ],
  providers: [
    ClientesService,
    ProprietariosService,
    ImoveisService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }