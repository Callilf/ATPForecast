import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { Router } from '@angular/router-deprecated';
import { Player } from './player';
import { PlayerService } from './player.service';



@Component({
  selector: 'my-players',
  template: `
  <h2>List of Players</h2>
  <ul class="players">
	<li *ngFor="let player of players" (click)="onSelect(player)" [class.selected]="player === selectedPlayer"
>
	  <span class="badge">{{player.id}}</span> {{player.name}}
	</li>
  </ul>
  <div *ngIf="selectedPlayer">
	  <h2>
		{{selectedPlayer.name | uppercase}} is my favorite !
	  </h2>
	  <button (click)="gotoDetail()">View Details</button>
  </div>
  `,
  styleUrls: ['ATPForecast/players.component.css']
})

export class PlayersComponent implements OnInit {
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

	onSelect(player: Player) { this.selectedPlayer = player; }
	
	gotoDetail() {
		this.router.navigate(['PlayerDetail', { id: this.selectedPlayer.id }]);
    }
}
