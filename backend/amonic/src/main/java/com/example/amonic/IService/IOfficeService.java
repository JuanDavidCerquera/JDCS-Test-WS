package com.example.amonic.IService;

import java.util.List;

import com.example.amonic.Entity.Offices;

public interface IOfficeService extends IBaseService<Offices> {

	List<Offices> getByFilter(
			String title,
			Long phone,
			String contact,
			Long countryId);
}
