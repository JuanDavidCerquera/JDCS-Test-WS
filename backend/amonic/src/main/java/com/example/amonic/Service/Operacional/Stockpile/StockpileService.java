package com.example.amonic.Service.Operacional.Stockpile;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amonic.IRepository.Operacional.Stockpile.StockpileRepository;
import com.example.amonic.IService.Operacional.Stockpile.IStockpileService;

@Service
public class StockpileService implements IStockpileService{
	
	@Autowired
	private StockpileRepository repo;

	@Override
	public List<Map<String, Object>> getStockpile() {
		
		
		return repo.findCustomData();
	}

}
