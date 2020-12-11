package com.allies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class KingdomEntity {
	
	String kingdomName;
	
	// Cipher sent by King Shaan to other kingdom's
	String cipherSentToKingdom;
	
	// Given cipher for a particular kingdom
	String correctCipherOfKingdom;
	
}
