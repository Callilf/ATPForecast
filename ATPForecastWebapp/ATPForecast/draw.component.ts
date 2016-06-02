import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { Router } from '@angular/router-deprecated';
import { Player } from './player';
import { PlayerService } from './player.service';



@Component({
  selector: 'my-draw',
  templateUrl: 'ATPForecast/draw.component.html',
  styleUrls: ['ATPForecast/draw.component.css']
})

export class DrawComponent implements OnInit {
	players: Player[];
	selectedPlayer: Player;
	
	
	constructor(
    private router: Router,
    private playerService: PlayerService) { }
		
	getPlayers() {
		this.playerService.getPlayers().then(returnedPlayers => this.players = returnedPlayers);
	}
	
	ngOnInit() {
		this.getPlayers();
    }

	//onSelect(player: Player) { this.selectedPlayer = player; }
}
