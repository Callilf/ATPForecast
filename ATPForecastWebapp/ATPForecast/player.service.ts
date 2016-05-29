import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';

import { Player } from './player';
import { PLAYERS } from './mock-players';

@Injectable()
export class PlayerService {
	private urlBase = 'http://localhost:8080/ATPForecastRestful-1.0-SNAPSHOT';
	
	constructor(private http: Http) { }
	
	getPlayers(): Promise<Player[]> {
		var promise = this.http.get(this.urlBase + '/PlayerService/players').toPromise();
		return promise.then(response => response.json()).catch(this.handleError);
		
    }
	
	private handleError(error: any) {
	  console.error('An error occurred', error);
	  return Promise.reject(error.message || error);
	}

	
	getPlayer(id: number) {
		var promise = this.http.get(this.urlBase + '/PlayerService/player/' + id).toPromise();
		return promise.then(response => response.json()).catch(this.handleError);
	}

}
