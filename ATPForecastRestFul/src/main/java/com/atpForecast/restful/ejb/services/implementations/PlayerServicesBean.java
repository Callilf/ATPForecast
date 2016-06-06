/**
 * 
 */
package com.atpForecast.restful.ejb.services.implementations;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.atpForecast.restful.ejb.entities.PlayerBean;
import com.atpForecast.restful.ejb.services.interfaces.PlayerServicesInterface;
import com.atpForecast.restful.objects.Player;

/**
 * EJB Session bean associated to the PLAYER table.
 */
@Stateless
@TransactionManagement(value=TransactionManagementType.CONTAINER)
@TransactionAttribute(value=TransactionAttributeType.REQUIRED)
public class PlayerServicesBean implements PlayerServicesInterface {

	@PersistenceContext(unitName="mysqlPU")
	private EntityManager em;
	
	
	
	/* (non-Javadoc)
	 * @see com.atpForecast.restful.ejb.services.interfaces.PlayerServicesInterface#getPlayer(int)
	 */
	public Player getPlayer(int id) {
		PlayerBean playerBean = findById(id);
		Player player = new Player(playerBean.getId(), playerBean.getLastname());
		return player;
	}

	/* (non-Javadoc)
	 * @see com.atpForecast.restful.ejb.services.interfaces.PlayerServicesInterface#getAllPlayers()
	 */
	public List<Player> getAllPlayers() {
		Query namedQuery = this.em.createNamedQuery("findAllPlayers");
		List<PlayerBean> resultList = namedQuery.getResultList();
		List<Player> players = new ArrayList<>();
		for (PlayerBean pb : resultList) {
			players.add(new Player(pb.getId(), pb.getLastname()));
		}
		return players;
	}

	
	/**
	 * Get a PlayerBean by it's ID.
	 * @param id the id
	 * @return a PlayerBean
	 */
	private PlayerBean findById(int id) {
		PlayerBean playerBean = this.em.getReference(PlayerBean.class, id);
		return playerBean;
	}
}
