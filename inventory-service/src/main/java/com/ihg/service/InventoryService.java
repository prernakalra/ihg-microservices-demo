package com.ihg.service;

import java.util.List;

import com.ihg.model.InventoryType;

public interface InventoryService {
	
	public List<InventoryType> getInventory(long id, String startDate, String endDate) throws Exception;

}
