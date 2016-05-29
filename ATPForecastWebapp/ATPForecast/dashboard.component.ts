import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router-deprecated';

import { Player } from './player';
import { PlayerService } from './player.service';


@Component({
  selector: 'my-dashboard',
  templateUrl: 'ATPForecast/dashboard.component.html',
  styleUrls: ['ATPForecast/dashboard.component.css']
})

export class DashboardComponent implements OnInit {
  players: Player[] = [];
 
  constructor(
    private router: Router,
    private playerService: PlayerService) {
  }


  ngOnInit() {
    this.playerService.getPlayers() 
      .then(returnedPlayers => this.players = returnedPlayers.slice(0,5));
  }
  gotoDetail(player: Player) {
	let link = ['PlayerDetail', { id: player.id }];
	this.router.navigate(link);
  }

}

