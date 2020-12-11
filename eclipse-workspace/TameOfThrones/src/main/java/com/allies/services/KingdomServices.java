package com.allies.services;

import java.io.IOException;
import java.util.List;

import com.allies.dto.Kingdom;
import com.allies.model.KingdomEntity;

public interface KingdomServices {
	/* 
	 * Used interface as it can be extended to the weapons each kingdom will contribute and land/gold they bring 
	*/
	List<Kingdom> getEveryAlly(List<KingdomEntity> kingdomList) throws IOException;
}
