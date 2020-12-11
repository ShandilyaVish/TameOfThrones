package com.allies.services;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.allies.dto.Kingdom;
import com.allies.model.KingdomEntity;

public class KingdomAllyServicesImpl implements KingdomServices {
	
	//Number for forming alliance
	private final static int majorityToFormAlliance = 4;
	
	/*
	 * We will individually check the cipher sent to each kingdom
	 * Match the frequency of same character by correct and sent cipher
	 */
	
	private List<Kingdom> getFromRepo(List<KingdomEntity> kingdoms) throws IOException {
		 
		//It confirms whether any previous ciphers has been sent to the kingdom
		Map<String,Boolean> checkForSent = new HashMap<>();
		checkForSent.put("LAND", 	false);
		checkForSent.put("SPACE", 	false);
		checkForSent.put("WATER", 	false);
		checkForSent.put("ICE", 	false);
		checkForSent.put("AIR", 	false);
		checkForSent.put("FIRE", 	false);
		
		
		 List<Kingdom> allyKingdoms = new ArrayList<>();
		 allyKingdoms.add(new Kingdom("SPACE"));
		
		for(KingdomEntity kingdom : kingdoms) {
			
			String allyKingdomName = kingdom.getKingdomName();
			String cipherSentToKingdom = kingdom.getCipherSentToKingdom();
			String correctCipherOfKingdom = kingdom.getCorrectCipherOfKingdom();
			
			int shift = correctCipherOfKingdom.length();
			String decodeCipherSentToKingdom = new Decode().getDecodedCipher(cipherSentToKingdom, shift);
			/*
			 * To get the frequency of the decoded value of sent cipher
			 * and the original cipher
			 */
			Map<Character,Integer> requiredCipher = new KingdomAllyServicesImpl().
					getCipherFrequency(correctCipherOfKingdom);
			
			boolean isSentCipherCorrect = checkCorrectnessOfCipher(requiredCipher,decodeCipherSentToKingdom);
			
			//Check whether a message/cipher has already sent and if it is correct cipher
			boolean isKingdomCovered = checkForSent.get(allyKingdomName);
			
			if(isSentCipherCorrect && !isKingdomCovered) {
				Kingdom ally = new Kingdom(allyKingdomName);
				allyKingdoms.add(ally);
				checkForSent.put(allyKingdomName, true);
			}
		}
		
		//If the majority is not reached, remove all potential allies and declare NONE
		if(allyKingdoms.size() < majorityToFormAlliance) {
			allyKingdoms.removeAll(allyKingdoms);
			allyKingdoms.add(new Kingdom("NONE"));
		}
		
		return allyKingdoms;
	}
	
	/* Check individually for each kingdom the deciphered message
	 * helper method
	 * sentCipher is cipher sent by King Shaan
	 * requiredCipher is the correct cipher required to make an ally for King Shaan
	 */
	
	private boolean checkCorrectnessOfCipher(Map<Character, Integer> requiredCipher,
			String decodeCipherSentToKingdom) 
	{
		
		for(Character ch : decodeCipherSentToKingdom.toCharArray()) {
			if(requiredCipher.containsKey(ch)) {
				requiredCipher.put(ch, requiredCipher.get(ch)-1);
				if(requiredCipher.get(ch) == 0) requiredCipher.remove(ch);
			}
		}
		if(!requiredCipher.isEmpty()) return false;
		return true;
	}
	
	public  Map<Character, Integer> getCipherFrequency(String cipher) {
		Map<Character, Integer> cipherFrequency = new HashMap<>();
	
		for (Character ch : cipher.toCharArray()) {
			cipherFrequency.put(ch, cipherFrequency.getOrDefault(ch, 0)+1);
		}
		
		return cipherFrequency;
	}

	@Override
	public List<Kingdom> getEveryAlly(List<KingdomEntity> kingdoms) throws IOException {
		if(kingdoms.size() == 0) {
			Kingdom kingdom = new Kingdom("NONE");
			return Arrays.asList(kingdom);
		}
		List<Kingdom> allyKingdoms = new KingdomAllyServicesImpl().getFromRepo(kingdoms);
		
		return allyKingdoms;
	}
	
	
}
