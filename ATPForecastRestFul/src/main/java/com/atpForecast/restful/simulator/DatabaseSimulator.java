/**
 * 
 */
package com.atpForecast.restful.simulator;

import com.atpForecast.restful.objects.Player;

/**
 * Class used for testing purpose to simulate the database
 */
public class DatabaseSimulator {

	private static DatabaseSimulator instance;
	
	private DatabaseSimulator() {
		setPlayers(new Player[]{
				new Player(1, "Djokovic"),
				new Player(2, "Murray"),
				new Player(3, "Federer"),
				new Player(4, "Wawrinka"),
				new Player(5, "Nadal"),
				new Player(6, "Nishikori"),
				new Player(7, "Tsonga"),
				new Player(8, "Berdych"),
				new Player(9, "Raonic"),
				new Player(10, "Cilic"),
				new Player(11, "Ferrer"),
				new Player(12, "Gasquet"),
				new Player(13, "Goffin"),
				new Player(14, "Monfils"),
				new Player(15, "Thiem")
				});
	}
	
	/** The list of players. */
	private Player[] players;
	
	public static DatabaseSimulator getInstance() {
		if (instance == null) {
			instance = new DatabaseSimulator();
		}
		return instance;
	}
	

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}
}
