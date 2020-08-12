package com.mycast.gjp.service;

import java.util.List;

import com.mycast.gjp.dao.ZhangWuDao;
import com.mycast.gjp.domain.ZhangWu;

public class ZhangWuService {
	private ZhangWuDao Dao = new ZhangWuDao();

	public void addZhangWu(ZhangWu zw) {
		Dao.addZhangWu(zw);
	}

	public List<ZhangWu> select(String startDate, String endDate) {
		return Dao.select(startDate, endDate);
	}

	public List<ZhangWu> selectAll() {
		return Dao.selectAll();
	}

	public void editZhangWu(ZhangWu zw) {
		// TODO 自动生成的方法存根
		Dao.editZhangWu(zw);
	}

	public String deleteZhangWu(int zwid) {
		// TODO 自动生成的方法存根
		return Dao.deleteZhangWu(zwid);
		
	}
}
