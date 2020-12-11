package com.allies.repository;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.allies.model.KingdomEntity;

/*
 * It is to check whether user's input isValid
 */

class RepositoryTest {
	private Repository repository;
	private String filePath;
	FileOutputStream fos;
	
	@BeforeEach
	public void init() {
		repository = new RepositoryImpl();
		filePath = System.getProperty("user.dir") + "/src/test/resources";
	}

	@Test
	void testForEmpty() throws IOException  {
		String fileName = "/Empty.txt";
		
		List<KingdomEntity> kingdomList = repository.getKingdomCipher(filePath + fileName);
		Assertions.assertEquals(0, kingdomList.size());
	}
	
	@Test
	void testForSpaceSeperatedCipher() throws IOException {
		String fileName = "/SpacedCipher.txt";
		
		List<KingdomEntity> kingdomList = repository.getKingdomCipher(filePath + fileName);
		Assertions.assertEquals("AIR", kingdomList.get(0).getKingdomName());
		//verify(mock)
	}
	
	@Test
	void checkValidKingdom() {
		String fileName = "/WrongKingdom.txt";
		Exception exception  = Assertions.assertThrows(NullPointerException.class,
				() ->  repository.getKingdomCipher(filePath + fileName));
		
		Assertions.assertEquals("It is not Valid", exception.getMessage());
	}

}
