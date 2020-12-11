package com.allies.repository;

import java.io.IOException;
import java.util.List;

import com.allies.model.KingdomEntity;


public interface Repository{
	
	List<KingdomEntity> getKingdomCipher(String filePath) throws IOException;
	

}
