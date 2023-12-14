import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
const baseUrl = 'http://localhost:9900/api/home';
@Injectable({
 providedIn: 'root',
})
export class UserService {

 constructor(private http: HttpClient) {}
 getPublicContent(): Observable<any> {
 return this.http.get(baseUrl + '/all', { responseType: 'text' });
 }
 getUserData(): Observable<any> {
 return this.http.get(baseUrl + '/user', { responseType: 'text' });
 }
 getModeratorData(): Observable<any> {
 return this.http.get(baseUrl + '/mod', { responseType: 'text' });
}
 getAdminData(): Observable<any> {
 return this.http.get(baseUrl + '/admin', { responseType: 'text' });
 }
}
