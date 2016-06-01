/**
 * 
 */
package com.atpForecast.restful.ejb.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.atpForecast.restful.objects.Player;

/**
 * Services related to the Players.
 */
@Remote
public interface PlayerServicesInterface {

	/**
	 * Get a player given it's ID.
	 * @param id the ID
	 * @return the player associated to the ID, of null if no player has this ID.
	 */
	Player getPlayer(int id);
	
	/**
	 * Get all players from DB. 
	 * This will probablement be removed later.
	 * @return the list of all players
	 */
	List<Player> getAllPlayers();
}
