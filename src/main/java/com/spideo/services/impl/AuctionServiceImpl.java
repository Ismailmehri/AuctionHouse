package com.spideo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.spideo.exceptions.AuctionException;
import com.spideo.models.Auction;
import com.spideo.repository.AuctionRepository;
import com.spideo.services.AuctionService;

/**
 * This class implement {@link AuctionService} interface
 * @author ismail
 *
 */
@Service
public class AuctionServiceImpl implements AuctionService {

	@Autowired
	private AuctionRepository auctionRepository;
	
	@Override
	public void add(String auctionName) throws AuctionException {
		if (StringUtils.isEmpty(auctionName)) {
			throw new AuctionException("Invalid auction name");
		}
		
		Auction auction = new Auction();
		auction.setName(auctionName);
		auctionRepository.save(auction);
		
	}

	@Override
	public List<Auction> getAll() {
		return auctionRepository.findAll();
	}

	@Override
	public void deleteById(Long auctionId) throws AuctionException {
		if (null == auctionId) {
			throw new AuctionException("Auction id is null");
		}
		
		auctionRepository.deleteById(auctionId);
	}

}
