package com.mycast.gjp.view;

import java.util.List;
import java.util.Scanner;

import com.mycast.gjp.controller.ZhangWuController;
import com.mycast.gjp.domain.ZhangWu;
import com.mycast.gjp.service.ZhangWuService;

public class MainView {
	private ZhangWuController controller = new ZhangWuController();

	public void run() {

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("---------------管家婆家庭记账软件---------------");
			System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
			System.out.println("请输入要操作的功能序号[1-5]:");

			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				 addZhangWu();
				break;
			case 2:
				 editZhangWu();
				break;
			case 3:
				 deleteZhangWu();
				break;
			case 4:
				selectZhangWu();
				break;
			case 5:
				System.exit(0);
				break;

			}

		}
	}
	
	public void deleteZhangWu() {
		selectAll();
		System.out.println("你选择的是删除功能,请输入要删除的ID");
		Scanner sc = new Scanner(System.in);
		int zwid=sc.nextInt();
		String result= controller.deleteZhangWu(zwid);
		System.out.println(result);
	}
	
	public void editZhangWu() {
		selectAll();
		System.out.println("你选择的是编辑功能,请输入数据");
		Scanner sc=new Scanner(System.in);
		System.out.println("输入ID");
		int zwid=sc.nextInt();
		System.out.print("请输入类别：");
		String flname=sc.next();
		System.out.print("请输入账户：");
		String zhanghu=sc.next();
		System.out.print("请输入金额：");
		double money=sc.nextDouble();
		System.out.print("请输入时间：");
		String createtime=sc.next();
		System.out.print("请输入说明：");
		String description=sc.next();
		
		ZhangWu zw=new ZhangWu(zwid, flname, money, zhanghu, createtime, description);
		controller.editZhangWu(zw);
		System.out.println("账务编辑成功");
		
	}
	
	private void addZhangWu() {
		// TODO 自动生成的方法存根
		System.out.println("选择账务功能,请输入以下功能");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("请输入类别：");
		String flname=sc.next();
		System.out.print("请输入账户：");
		String zhanghu=sc.next();
		System.out.print("请输入金额：");
		double money=sc.nextDouble();
		System.out.print("请输入时间：");
		String createtime=sc.next();
		System.out.print("请输入说明：");
		String description=sc.next();
		
		
		ZhangWu zw =new ZhangWu(0, flname, money, zhanghu, createtime, description);
		controller.addZhangWu(zw);
		System.out.println("添加账务成功！");


	}

	public void selectZhangWu() {
		System.out.println("1.查询所有　2.按条件查询");
		Scanner sc = new Scanner(System.in);
		int selectChooser = sc.nextInt();
		switch (selectChooser) {
		case 1:
			selectAll();
			break;
		case 2:
			select();
			break;
		default:
			break;
		}

	}

	public void selectAll() {
		List<ZhangWu> list = controller.selectAll();
		if (list.size()!=0) {
			print(list);
		}else {
			System.out.println("没有找到信息");
		}
	}

	public void select() {
		System.out.println("选择条件查询,输入日期格式为XXXX-XX-XX");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入开始日期");
		String startDate = sc.nextLine();
		System.out.println("请输入结束日期");
		String endDate = sc.nextLine();

		List<ZhangWu> list = controller.select(startDate, endDate);
		if (list.size()!=0) {
			print(list);
		}else {
			System.out.println("没有找到信息");
		}
		

	}

	private void print(List<ZhangWu> list) {
		System.out.println("ID\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
		for (ZhangWu zw : list) {
			System.out.println(zw.getZwid() + "\t" + zw.getFlname() + "\t\t" + zw.getZhanghu() + "\t\t" + zw.getMoney()
					+ "\t\t" + zw.getCreatetime() + "\t" + zw.getDescription());

		}
	}
}
