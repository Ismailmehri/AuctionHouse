package com.spideo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spideo.exceptions.AuctionException;
import com.spideo.models.Auction;
import com.spideo.services.AuctionService;

/**
 * This class expose {@link Auction} web services
 * @author ismail
 *
 */
@RestController
@RequestMapping("/auction")
public class AuctionController {

	@Autowired
	private AuctionService auctionService;
	
	/**
	 * Create a new {@link Auction} house
	 * @param name the name of {@link Auction} house
	 * @throws AuctionException on error
	 */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAuctionHouse(@RequestParam(name = "name") String name) throws AuctionException {
    	auctionService.add(name);
    }
    
    /**
     * Return a list of {@link Auction}
     * @return
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Auction> getAllAuctionHouse() {
    	return auctionService.getAll();
    }
    
    /**
     * Delete an {@link Auction} house by id
     * @param id ths id
     * @throws AuctionException on error
     */
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAuctionHouse(@PathVariable("id") Long id) throws AuctionException {
    	auctionService.deleteById(id);
    }
}
