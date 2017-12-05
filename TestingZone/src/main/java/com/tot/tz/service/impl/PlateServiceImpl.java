package com.tot.tz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tot.tz.dao.PlateDao;
import com.tot.tz.entity.Plate;
import com.tot.tz.service.PlateService;

@Service("plateService")
public class PlateServiceImpl implements PlateService {

	@Resource
	private PlateDao plateDao;

	@Override
	public List<Plate> getPlateList() {
		return this.plateDao.getPlateList();
	}


}
