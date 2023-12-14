import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { authInterceptorProviders } from './security/auth.interceptor';
import { AppComponent } from './app.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { RegisterPageComponent } from './pages/register-page/register-page.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { ProfilePageComponent } from './pages/profile-page/profile-page.component';
import { AdminPageComponent } from './pages/admin-page/admin-page.component';
import { ModeratorPageComponent } from './pages/moderator-page/moderator-page.component';
import { UserPageComponent } from './pages/user-page/user-page.component';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app.routing';
@NgModule({
 declarations: [
 AppComponent,
 LoginPageComponent,
 RegisterPageComponent,
 HomePageComponent,
 ProfilePageComponent,
 AdminPageComponent,
 ModeratorPageComponent,
 UserPageComponent
 ],
 imports: [
 BrowserModule,
 AppRoutingModule,
 FormsModule,
 HttpClientModule
 ],
 providers: [authInterceptorProviders],
 bootstrap: [AppComponent]
})
export class AppModule { }

