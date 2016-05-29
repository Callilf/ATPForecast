import { Component, OnInit } from '@angular/core';
import { RouteParams } from '@angular/router-deprecated';
import { PlayerService } from './player.service';

import { Player } from './player';
@Component({
  selector: 'my-player-detail',
  templateUrl: 'ATPForecast/player-detail.component.html',
styleUrls: ['ATPForecast/player-detail.component.css']
})
export class PlayerDetailComponent implements OnInit {
  player: Player;
  
  constructor(private playerService: PlayerService, private routeParams: RouteParams) {}
  
  ngOnInit() {
    let id = +this.routeParams.get('id');
	console.log("Detail for player with id = " + id);
    this.playerService.getPlayer(id)
      .then(returnedPlayer => this.player = returnedPlayer);
  }
  
  goBack() {
	window.history.back();
  }



}
