package com.mycast.gjp.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.omg.Messaging.SyncScopeHelper;

import com.mycast.gjp.domain.ZhangWu;
import com.mycast.gjp.tools.JDBCUtils;

public class ZhangWuDao {
	QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
	
	public void addZhangWu(ZhangWu zw) {
		try {
			String sql = "insert into gjp_zhangwu(flname,money,zhanghu,createtime,description) values(?,?,?,?,?)";
		
			Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
			qr.update(sql, params);
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("账务添加失败");
		}	

	}
	
	public List<ZhangWu> select(String startDate, String endDate) {
	
	try {
		String sql="SELECT * FROM gjp_zhangwu WHERE  createtime BETWEEN ? AND ?";
		Object[] params= {startDate,endDate};
		
	return qr.query(sql, new BeanListHandler<>(ZhangWu.class),params);
	}catch (SQLException ex) {
		// TODO: handle exception
		System.out.println(ex);
		throw new RuntimeException("条件查询失败");
	}
	}
	
	public List<ZhangWu> selectAll() {
		String sql="select * from gjp_zhangwu";
		
		try {
		return qr.query(sql, new BeanListHandler<ZhangWu>(ZhangWu.class));
	}catch (SQLException ex) {
		// TODO: handle exception
		System.out.println(ex);
		throw new RuntimeException("查询所有业务失败");
	}
	}

	
	public void editZhangWu(ZhangWu zw) {
		// TODO 自动生成的方法存根
		String sql = "update gjp_zhangwu set flname=?, money=?,zhanghu=?,createtime=?,description=? where zwid=?";
		try {
			Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
			qr.update(sql, params);
		} catch (SQLException e) {
			
			System.out.println(e);
			throw new RuntimeException("账务编辑失败");
		}	

	}

	public String deleteZhangWu(int zwid) {
		// TODO 自动生成的方法存根
		String string="删除取消";
		String string2="删除成功";
		System.out.println("你真的要删除id为 "+ zwid+"的数据吗?确认输入1,否则输入其他");
		
		Scanner sc=new Scanner(System.in);
		int yes=sc.nextInt();
		if (yes==1) {
			String sql = "delete from gjp_zhangwu where zwid=?";
		try {
			qr.update(sql, zwid);
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("删除账务失败");
		}
		}else {
			return string;
		}
		
		return string2;
		
	}
}
