package com.allies;

import java.io.IOException;
import java.util.List;

import com.allies.dto.Kingdom;
import com.allies.model.KingdomEntity;
import com.allies.repository.Repository;
import com.allies.repository.RepositoryImpl;
import com.allies.services.KingdomAllyServicesImpl;
import com.allies.services.KingdomServices;

public class Geektrust {
	
	
	
	public static void main(String[] args) throws IOException, NullPointerException{
		
		// As the filePath is read as command while running it as jar file
		String filePath = args[0];
		
		List<Kingdom> allyKingdoms = null;
		
		try {
			allyKingdoms = new Geektrust().getAllies(filePath);
			for(Kingdom allyKingdom : allyKingdoms) {
				System.out.print(allyKingdom.getKingdomName() + " ");
			}
		} catch (NullPointerException e) {
			System.out.println("NO KINGDOM AS SUCH FOUND");
		}
		
	}
	
	public List<Kingdom> getAllies(String filePath) throws IOException, NullPointerException {
		
		KingdomServices kingdomServices = new KingdomAllyServicesImpl();
		Repository repository = new RepositoryImpl();
		
		/*
		 * Check if the kingdom is in the list of 6 kingdoms, if not present
		 * then print "NOKINGDOM AS SUCH FOUND"
		 */
		List<KingdomEntity> kingdomEntity;
		try {
			kingdomEntity = repository.getKingdomCipher(filePath);
		} catch (NullPointerException e) {
			throw new NullPointerException("No kingom as such");
		}
		
		List<Kingdom> allyKingdoms = kingdomServices.getEveryAlly(kingdomEntity);

		return allyKingdoms;
	}
	
}
//C:\Users\vishr\OneDrive\Documents\Input.txt