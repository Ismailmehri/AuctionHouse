package com.spideo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Auction entity
 * @author ismail
 *
 */

@Entity
@Table(name = "T_AUCTION")
public class Auction {
	
	@Id
	@Column(name = "auction_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	private String name;

	/**
	 * Return the auction id
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the auction id
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Return ths auction name
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the auction name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
