/**
 * 
 */
package com.atpForecast.restful.ejb.services;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.atpForecast.restful.ejb.services.implementations.PlayerServicesBean;
import com.atpForecast.restful.ejb.services.interfaces.PlayerServicesInterface;

/**
 * Factory for the EJB services.
 */
public final class ServicesFactory {

	/**
	 * Forbidden constructor.
	 */
	private ServicesFactory(){}
	
	
	/**
	 * Lookup the PlayerServices
	 * @return {@link PlayerServicesInterface}
	 * @throws NamingException if the lookup failed
	 */
	public static PlayerServicesInterface getPlayerServices() throws NamingException {
		PlayerServicesInterface psi = (PlayerServicesInterface) new InitialContext().lookup("java:global/ATPForecastRestful-1.0-SNAPSHOT/PlayerServicesBean!com.atpForecast.restful.ejb.services.interfaces.PlayerServicesInterface");
		return psi;
	}
	
}
