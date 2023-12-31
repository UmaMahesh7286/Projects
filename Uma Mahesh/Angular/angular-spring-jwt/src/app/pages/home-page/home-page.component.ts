import { RouterModule } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
@Component({
 selector: 'app-home-page',
 templateUrl: './home-page.component.html',
 styleUrls: ['./home-page.component.css'],
})
export class HomePageComponent implements OnInit {
 content?: string;
 constructor(private userService: UserService,private router:RouterModule) {}
 ngOnInit(): void {
 this.userService.getPublicContent().subscribe(
 (data) => {
 this.content = data;
 },
 (err) => {
 console.log(err);
 }
 );
 }
}
