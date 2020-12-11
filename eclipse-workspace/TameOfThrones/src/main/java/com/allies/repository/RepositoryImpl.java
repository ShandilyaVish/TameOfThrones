package com.allies.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.allies.model.KingdomEntity;

public class RepositoryImpl implements Repository{
	
	/*
	 * Function to the read the file,given its path.
	 * Check for if user provided any kingdom not present in db
	 * Send it as list of Entities
	 */
	private List<KingdomEntity> getKingdomFromFile(String filePath) throws IOException, NullPointerException {
		List<KingdomEntity> kingdoms = new ArrayList<>();
		String line;
		File file = new File(filePath);
		
		//Call getKingdomCipher() to check whether there exists a kingdom provided by user input
		
		
		//Read the data 
		
		BufferedReader br = new BufferedReader(new FileReader(file));
				
		while((line = br.readLine()) != null ) {
						
			String input[] = line.split(" ");
			String kingdomName = input[0];
			String cipherSent = "";
			
			//Calling the correct cipher for the given kingdom
			String correctCipher = CiphersOfKingdoms.getKingdomCipher(kingdomName);
			
			if(correctCipher.equals("")) {
				throw new NullPointerException("It is not Valid");
			}
			
			
			//It is to read the cipher input, immaterial of space between the ciphers
			for(int i = 1;i < input.length;i++) {
				cipherSent += input[i];
			}
			
			KingdomEntity ally = new KingdomEntity(kingdomName, cipherSent,correctCipher);
			kingdoms.add(ally);
		}
		
		br.close();
		
		return kingdoms;
	}


	@Override
	public List<KingdomEntity> getKingdomCipher(String filePath) throws IOException {
		
		return new RepositoryImpl().getKingdomFromFile(filePath);
	}
	
}
