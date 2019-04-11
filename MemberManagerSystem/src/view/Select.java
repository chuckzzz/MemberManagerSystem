/**
 *	@author：     chuck
 *	@version：    2.0版
 *  日期：      2016-9-20下午8:18:16
 */


package view;

import java.util.Scanner;

import dao.AdminRegister;
import dao.MemberDao;


public class Select {
	PrintMessage p = new PrintMessage();
	AdminRegister r = new AdminRegister();
	MemberDao md = new MemberDao();
	boolean state = false;
	//选择方法
	public void choice(){
		Scanner in = new Scanner(System.in);
		try {
			while(true){
				//首页
				p.printWelcomInterface();
				//输入
				String choice = in.nextLine();
				while("".equals(choice)){
					System.out.println("请勿输入为空！请重新输入：");
					choice = in.nextLine();
				}
				int temp = Integer.parseInt(choice);
				
				switch(temp){
					//1、登录管理会员
					case 1:
						login();break;
					//2、添加管理员
					case 2:
						add();break;
					//3、退出
					case 3:
						System.out.println("谢谢使用骁龙二部健身会员系统！期待你的下次登录！");
						return;
					default: System.out.println("操作有误，请重新输入！");
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("没按要求输入数字，系统自动关闭！" +
					"\n下次使用请按要求输入数字，谢谢合作！");
		}
	
	}
	//添加管理员方法
	private void add() {
		if(r.Admin(state)){
			r.addAdmin();
		}
	}
	
	//登录管理
	private void login(){
		if(r.Admin(state)){
			while(true){
				//首页
				p.printSelectInterface();
				Scanner in =new Scanner(System.in);
				//输入
				String choice = in.nextLine();
				if(choice.equals("n")){
					state = true;
					break;
				}
				int temp = Integer.parseInt(choice);
				switch(temp){
					//1、显示所有会员信息
					case 1:
						md.list(r.trans());
						back();
					break;
					
					//2、添加会员信息 
					case 2:
						md.add(r.trans());
						back();
						break;
					//3、修改会员信息
					case 3:
						md.updata(r.trans());
						back();
						break;
					//4、查询会员信息
					case 4:
						md.select(r.trans());
						break;
					//5、删除
					case 5:
						md.delete(r.trans());
						break;
					//6、注销
					case 6:
						state=false;
						return;
					//7、退出
					case 7:
						System.out.println("谢谢使用骁龙二部健身会员系统！期待你的下次登录！");
						System.exit(0);
					default: System.out.println("操作有误，请重新输入！");
				}
			}
		}
	}	
	//返回操作
	private void back(){
		Scanner in = new Scanner(System.in);
		System.out.println("请输入n返回上一界面");
		int k=0;
		while(!"n".equals(in.nextLine())){
			System.out.println("请输入n返回上一界面");
			k++;
			if(k>2){
				System.out.println("您的操作次数已用完，系统结束");
				System.exit(0);
			}
		}
	}
}
