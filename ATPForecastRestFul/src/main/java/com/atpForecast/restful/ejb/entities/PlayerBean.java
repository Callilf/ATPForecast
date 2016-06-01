/**
 * 
 */
package com.atpForecast.restful.ejb.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Represents a Player in the table PLAYER.
 */
@Entity
@Table(name="PLAYER")
@NamedQueries({ 
	@NamedQuery(
			name = "findAllPlayers", 
			query = "SELECT p FROM PlayerBean p") 
	}
)
public class PlayerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * The player ID.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column (name="LASTNAME")
	private String lastname;
	
	@Column (name="FIRSTNAME")
	private String name;
	
	/**
	 * The current ATP rank.
	 */
	@Column (name="RANK")
	private int rank;

	
	
	// Getters & Setters
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
}
