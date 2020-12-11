package com.allies.services;


public class Decode {
	
	private String decodeTheCipher(String encode,int cipherKey) {
		
		StringBuilder decode = new StringBuilder();
		int asciiA =  'A';
		int totalAlphabets = 26;
		
		for(Character ch : encode.toCharArray()) {
			int encodedCharaPos = ch;
			char shifted;
			if(encodedCharaPos - cipherKey < asciiA) {
				int diffFromAsciiStart = encodedCharaPos - asciiA;
				int shift = asciiA + (totalAlphabets - (cipherKey - diffFromAsciiStart));
				shifted = (char) shift;
			}
			else {
				shifted = (char) (encodedCharaPos - cipherKey); 
			}
			decode.append(shifted);
		}
		return decode.toString();
	}
	
	public String getDecodedCipher(String encode,int cipherKey) {
		String decode = new Decode().decodeTheCipher(encode, cipherKey);
		return decode;
	}
}

