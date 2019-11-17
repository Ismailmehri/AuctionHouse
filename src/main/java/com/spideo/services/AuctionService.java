package com.spideo.services;

import java.util.List;

import com.spideo.exceptions.AuctionException;
import com.spideo.models.Auction;

/**
 * {@link Auction} services
 * @author ismail
 *
 */
public interface AuctionService {

	/**
	 * Add a new {@link Auction} by Name
	 * @param auctionName the {@link Auction} name
	 * @throws AuctionException on error
	 */
	public void add(String auctionName) throws AuctionException;
	
	/**
	 * Return all {@link Auction}s
	 * @return list of {@link Auction}
	 */
	public List<Auction> getAll();
	
	/**
	 * Delete a specific {@link Auction} house.
	 * @param auctionId the {@link Auction} that will deleted
	 * @throws AuctionException on error
	 */
	public void deleteById(Long auctionId) throws AuctionException;
}
