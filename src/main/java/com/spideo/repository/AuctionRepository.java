package com.spideo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spideo.models.Auction;

/**
 * {@link Auction} repository
 * @author ismail
 *
 */
public interface AuctionRepository extends JpaRepository<Auction, Long> {
	
}
