import { NgModule } from '@angular/core';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { RegisterPageComponent } from './pages/register-page/register-page.component';
import { ProfilePageComponent } from './pages/profile-page/profile-page.component';
import { UserPageComponent } from './pages/user-page/user-page.component';
import { ModeratorPageComponent } from './pages/moderator-page/moderator-page.component';
import { AdminPageComponent } from './pages/admin-page/admin-page.component';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
 { path: 'home', component: HomePageComponent },
 { path: 'login', component: LoginPageComponent },
 { path: 'register', component: RegisterPageComponent },
 { path: 'profile', component: ProfilePageComponent },
 { path: 'user', component: UserPageComponent },
 { path: 'mod', component: ModeratorPageComponent },
 { path: 'admin', component: AdminPageComponent },
 { path: '', redirectTo: 'home', pathMatch: 'full' },
];
@NgModule({
 imports: [RouterModule.forRoot(routes)],
 exports: [RouterModule],
})
export class AppRoutingModule {}
