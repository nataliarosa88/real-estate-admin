import { AuthGuard } from './_services/auth_guard.service';
import { LoginComponent } from './login/login.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms'
import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { RegisterComponent } from './register/register.component';
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
import { TiposModule } from './tipos/tipos.module';
import { TiposService } from './tipos.service';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { TextMaskModule } from 'angular2-text-mask';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [

    BrowserModule,
    AppRoutingModule,
    TemplateModule,
    ProprietariosModule,
    TiposModule,
    ImoveisModule,
    ClientesModule,
    FormsModule,
    HttpClientModule,
    Ng2SearchPipeModule,
    ReactiveFormsModule,
    TextMaskModule
  ],
  providers: [
    
    ClientesService,
    ProprietariosService,
    TiposService,
    ImoveisService,
    AuthGuard, 
    authInterceptorProviders
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
