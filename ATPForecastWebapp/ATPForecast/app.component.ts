import { Component }       from '@angular/core';
import { PlayerService }     from './player.service';
import { DrawComponent } from './draw.component';
import { PlayersComponent } from './players.component';
import { PlayerDetailComponent } from './player-detail.component';
import { DashboardComponent } from './dashboard.component';
import { RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS } from '@angular/router-deprecated';

@Component({
  selector: 'atp-forecast',
  template: `
    <h1>{{title}}</h1>
    <nav>
      <a [routerLink]="['Dashboard']">Dashboard</a>
      <a [routerLink]="['Players']">Players</a>
      <a [routerLink]="['Draw']">Draw</a>
    </nav>
    <router-outlet></router-outlet>
  `,
  styleUrls: ['ATPForecast/app.component.css'],
  directives: [ROUTER_DIRECTIVES],
  providers: [
    PlayerService,
	ROUTER_PROVIDERS
  ]
})

@RouteConfig([
  {
    path: '/players',
    name: 'Players',
    component: PlayersComponent
  },
  {
    path: '/dashboard',
    name: 'Dashboard',
    component: DashboardComponent,
    useAsDefault: true
  },
  {
    path: '/detail/:id',
    name: 'PlayerDetail',
    component: PlayerDetailComponent
  },
  {
    path: '/draw/',
    name: 'Draw',
    component: DrawComponent
  }
])

export class AppComponent {
  title = 'ATP Draw Forecast Application';
}
