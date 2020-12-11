package com.allies.services;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.allies.dto.Kingdom;
import com.allies.model.KingdomEntity;

public class KingdomServicesTest {
	
	private KingdomServices kingdomServices;
	private final String land = "PANDA";
	private final String ice = "MAMMOTH";
	private final String air = "OWL";
	
	
	@BeforeEach
	private void init() {
		kingdomServices = new KingdomAllyServicesImpl();
	}
	
	//Check when no input/message sent
	@Test
	public void testForEmpty() throws IOException {
		List<KingdomEntity> kingdomEntity = new ArrayList<KingdomEntity>();
		
		List<Kingdom> allyKingdoms = kingdomServices.getEveryAlly(kingdomEntity);
		
		Assertions.assertEquals(1, allyKingdoms.size());
		Assertions.assertEquals("NONE", allyKingdoms.get(0).getKingdomName());
	}
	
	
	/*
	 * Test to check for multiple ciphers sent to one kingdom
	 * It also tests when there are other cipher for other kingdoms, it will return only when majority(i.e 4) reached;
	 */
	@Test
	public void testForRepeatation() throws IOException {
		List<KingdomEntity>  kingdomEntitites = new ArrayList<KingdomEntity>();
		
		KingdomEntity kingdomEntityAir1 = new KingdomEntity("AIR", "OWLROZ", air);
		KingdomEntity kingdomEntityAir2 = new KingdomEntity("AIR","ZPWORK",air);
		KingdomEntity kingdomEntityLand = new KingdomEntity("LAND", "FISFU", land);
		KingdomEntity kingdomEntityIce = new KingdomEntity("ICE", "TTTHVAOS", ice);
		
		kingdomEntitites.add(kingdomEntityAir1);
		kingdomEntitites.add(kingdomEntityAir2);
		kingdomEntitites.add(kingdomEntityLand);
		kingdomEntitites.add(kingdomEntityIce);
		
		
		List<Kingdom> allyKingdoms = kingdomServices.getEveryAlly(kingdomEntitites);
		
		Assertions.assertEquals("SPACE", allyKingdoms.get(0).getKingdomName());
		Assertions.assertEquals("AIR", allyKingdoms.get(1).getKingdomName());
		Assertions.assertEquals("LAND", allyKingdoms.get(2).getKingdomName());
		Assertions.assertEquals("ICE", allyKingdoms.get(3).getKingdomName());
		
		Assertions.assertEquals(4, allyKingdoms.size());
		
				
	}	
	
	/*
	 * Test when small case letters are sent
	 */
	@Test	
	public void testForCaseSensitive() throws IOException {
		List<KingdomEntity>  kingdomEntitites = new ArrayList<KingdomEntity>();
		
		KingdomEntity kingdomEntityAir = new KingdomEntity("AIR","rozo",air);
		KingdomEntity kingdomEntityLand = new KingdomEntity("LAND", "fisfu", land);
		KingdomEntity kingdomEntityIce = new KingdomEntity("ICE", "ttthvaos", ice);
		
		kingdomEntitites.add(kingdomEntityAir);
		kingdomEntitites.add(kingdomEntityLand);
		kingdomEntitites.add(kingdomEntityIce);
		
		List<Kingdom> allyKingdoms = kingdomServices.getEveryAlly(kingdomEntitites);
		
		Assertions.assertEquals(1, allyKingdoms.size());
		Assertions.assertEquals("NONE", allyKingdoms.get(0).getKingdomName());
	}
}
