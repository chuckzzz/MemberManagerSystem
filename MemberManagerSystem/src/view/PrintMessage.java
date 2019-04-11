/**
 *	@author：     chuck
 *	@version：    2.0版
 *  日期：      2016-9-20下午4:52:22
 */


package view;

public class PrintMessage {

	//欢迎界面
	public void printWelcomInterface(){
		//管理系统主界面，第一个界面
		System.out.println("     欢迎使用骁龙二部健身会员管理系统");
		System.out.println("*****************************************");
		System.out.println("               1.登录（查看会员信息）");
		System.out.println("               2.登录（添加管理员）");
		System.out.println("               3.退 出");
		System.out.println("*****************************************");
		System.out.println("请输入数字选择操作：");
	}
	
	//添加管理员界面
	public void printAdd(){
		//管理系统主界面，第一个界面
		System.out.println("     欢迎使用骁龙二部健身会员管理系统");
		System.out.println("*****************************************");
		System.out.println("               1.添加管理员用户");
		System.out.println("               2.列出所有管理员");
		System.out.println("               3.修  改  密  码");
		System.out.println("               4.退         出");
		System.out.println("*****************************************");
		System.out.println("(输入n返回)请选择，输入数字：");
	}
	
	//选择界面
	public void printSelectInterface(){
		//登陆后界面，第二个界面
		System.out.println("     欢迎使用骁龙二部健身会员管理系统");
		System.out.println("*****************************************");
		System.out.println("       1.显示所有会员信息");
		System.out.println("       2.添加会员信息");
		System.out.println("       3.修改会员信息");
		System.out.println("       4.查询会员信息");
		System.out.println("       5.删除会员信息");
		System.out.println("       6.注销");
		System.out.println("       7.退出");
		System.out.println("请选择，输入数字或按'n'返回上级菜单：");
	}
	
	//会员信息界面
	public void printMemberInfo(){
		System.out.println("会员号          生日        姓名        手机号     地址");
		System.out.println("-------|-------|------|--------|---------");
		
	}

	//添加会员信息
	public void printAddMemberView(){
		System.out.println("         2.添加会员信息");
		System.out.println("请按'n'返回上级菜单：");
		System.out.println("骁龙二部健身会员管理系统>会员信息管理>添加会员信息");
		System.out.println("请输入会员号(四位整数)：");
		System.out.println("请输入姓名：");
		System.out.println("请输入会员生日(月/日<用两位数表示>)");
		System.out.println("请输入手机号(11位)：");
		System.out.println("请输入地址：");
		System.out.println("新会员添加成功！");
		System.out.println("继续添加会员吗（y/n）：");
		System.out.println("请输入会员号（四位整数）：");
	}
	
	//修改会员信息
	public void printMemberUpdata(){
			System.out.println("        3.修改会员信息");
			System.out.println("请输入会员号：");
			System.out.println("会员号          生日        姓名        手机号     地址");
			System.out.println("-------|-------|------|--------|---------");
			System.out.println("*******************************");
			System.out.println("      1.修改会员姓名");
			System.out.println("      2.修改会员生日");
			System.out.println("      3.修改会员手机号");
			System.out.println("      4.修改会员地址");
			System.out.println("      请选择，并输入数字：");
			System.out.println("      请输入修改后的姓名：");
			System.out.println("      请输入修改后的生日：");
			System.out.println("      请输入修改后的手机号：");
			System.out.println("      请输入修改后的地址：");
			System.out.println("      姓名信息已更改！");
			System.out.println("      生日信息已更改！");
			System.out.println("      手机号信息已更改！");
			System.out.println("      地址信息已更改！");
			System.out.println("      是否修改其他信息(y/n):");
	
	}
}
