package com.spideo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.spideo.exceptions.AuctionException;
import com.spideo.models.Auction;
import com.spideo.repository.AuctionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode =DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuctionServiceTest {
	
	@Autowired
	private AuctionService auctionService;
	
	@Autowired
	private AuctionRepository auctionRepository;
	
	@Test
	public void createAuctionHouseWithName() throws AuctionException {
		
		//Given
		String expectedName = "first";
		
		//When
		auctionService.add(expectedName);
		
		//Then
		List<Auction> auctions = auctionRepository.findAll();
		
		assertNotNull(auctions);
		assertEquals(1, auctions.size());
		assertEquals(expectedName, auctions.get(0).getName());
		
	}

	@Test(expected = AuctionException.class)
	public void createAuctionHouseWithEmptyName() throws AuctionException {
		
		//Given
		String expectedName = "";
		
		//When
		auctionService.add(expectedName);
		
	}
	
	@Test(expected = AuctionException.class)
	public void createAuctionHouseWithNullName() throws AuctionException {
		
		//Given
		String expectedName = null;
		
		//When
		auctionService.add(expectedName);
		
	}
	
	@Test
	public void returnAllAuctionsHouse() throws AuctionException {
		
		//Given
		String expectedNameOne = "one";
		String expectedNameTow = "two";
		Auction one = new Auction();
		Auction two = new Auction();
		one.setName(expectedNameOne);
		two.setName(expectedNameTow);
		
		auctionRepository.saveAll(Arrays.asList(one, two));
		
		//When
		List<Auction> actualList = auctionService.getAll();
		
		//Then
		assertNotNull(actualList);
		assertEquals(2, actualList.size());
	}
	
	@Test
	public void deleteAnAuctionsHouse() throws AuctionException {
		
		//Given
		String expectedNameOne = "one";
		auctionService.add(expectedNameOne);
		List<Auction> actualList = auctionService.getAll();
		
		//When
		auctionService.deleteById(actualList.get(0).getId());
		
		//Then
		actualList = auctionService.getAll();
		assertNotNull(actualList);
		assertEquals(0, actualList.size());
	}
	
	@Test(expected = AuctionException.class)
	public void deleteAnAuctionsHouseWithNullObject() throws AuctionException {
		
		//Given
		String expectedNameOne = "one";
		auctionService.add(expectedNameOne);
		
		//When
		auctionService.deleteById(null);
	}
}
