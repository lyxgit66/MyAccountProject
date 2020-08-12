package com.mycast.gjp.controller;

import java.util.List;

import com.mycast.gjp.domain.ZhangWu;
import com.mycast.gjp.service.ZhangWuService;

public class ZhangWuController {
	private ZhangWuService service=new ZhangWuService();
	
	public String deleteZhangWu(int zwid) {
		return service.deleteZhangWu(zwid);
	}
	
	public void editZhangWu(ZhangWu zw) {
		service.editZhangWu(zw);
	}
	
	public void addZhangWu(ZhangWu zw) {
		service.addZhangWu(zw);
	}
	
	public List<ZhangWu> select(String startDate, String endDate) {
		return service.select(startDate, endDate);
	}
	
	public List<ZhangWu> selectAll() {
		return service.selectAll();
	}
}
