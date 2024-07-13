package com.example.amonic.IService.Operacional.AirLine;

import java.util.List;

import com.example.amonic.Entity.Operacional.Offices;
import com.example.amonic.IService.Base.IBaseService;

public interface IOfficeService extends IBaseService<Offices> {

	List<Offices> getByFilter(
			String title,
			Long phone,
			String contact,
			Long countryId);
}
