package com.allies.repository;


/*Stores the ciphers for each kingdom
*Stores position of all capital letter from  A-Z
*Using final as no hamper to original data and can only be changed by altering the below code
*/

public class CiphersOfKingdoms {

	public final static String getKingdomCipher(String kingdomName) {
		String cipher;
		switch (kingdomName) {
		case "LAND":
			cipher = "PANDA";
			break;
		case "SPACE":
			cipher = "GORILLA";
			break;
		case "WATER":
			cipher = "OCTOPUS";
			break;
		case "ICE":
			cipher = "MAMMOTH";
			break;
		case "AIR":
			cipher = "OWL";
			break;
		case "FIRE":
			cipher = "DRAGON";
			break;
		
		default:
			cipher = "";
			break;
		}
		return cipher;
	}
	
}
