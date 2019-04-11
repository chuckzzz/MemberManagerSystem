/**
 *	@author：     chuck
 *	@version：    2.0版
 *  日期：      2019-4-10下午8:28:28
 */


package dao;

import java.util.Scanner;

import view.Data;
import view.PrintMessage;
import model.Admin;


public class AdminRegister {
	PrintMessage pm = new PrintMessage();
	Data d = new Data();
	static int j=1;
	private int uu;

	public AdminRegister(){
		//创建新的对象
		for(int j=0;j<d.admin.length;j++){
			d.admin[j]=new Admin();
		}
		d.admin[0].setUsername("123");
		d.admin[0].setPassword("123");
		d.admin[0].setId(0);
	}
	//添加管理员选择界面
	public void addAdmin(){
		
		while(true){
			pm.printAdd();
			Scanner in = new Scanner(System.in);
			String choice = in.nextLine();
			if(choice.equals("n")) {
				break;
			}
			int temp = Integer.parseInt(choice);
			if(temp==1){
				System.out.println("骁龙二部健身会员管理系统>请输入添加的管理账号：");
				String username = in.nextLine();
				String password ;
				if(judgeThis(username)){
					System.out.println("骁龙二部健身会员管理系统>请输入添加的管理员密码：");
					password= in.nextLine();
					addThis(username, password);//添加输入的管理员账号和密码
				}
			}else if(temp==2){
				adminList();
			}else if(temp==3){
				update();
			}else if(temp==4){
				System.out.println("谢谢使用骁龙二部健身会员系统！期待你的下次登录！");
				System.exit(0);
			}else{
				System.out.println("输入不符合规范，请按要求输入操作符！");
			}
		}
	}
	//修改密码
	private void update() {
		int n=0;
		Scanner input=new Scanner(System.in);
		System.out.println("请输入本管理员密码：");
		String password=input.nextLine();
		while("".equals(password)){
			System.out.println("输入密码不能为空！请重新输入：");
			password=input.nextLine();
		}
		//控制密码长度
//		while(password.length()<6){
//			System.out.println("输入密码不能小于6位！请重新输入：");
//			password=input.nextLine();
//		}
		if(d.admin[uu].getPassword().equals(password)){
			System.out.println("请重设密码：");
			String password2=input.nextLine();
			
			while(password.equals(password2)){
				n++;
				if(n>2){
					System.out.println("重设失败！系统返回。");
					break;
				}
				System.out.println("密码与原密码不能重复，请重设密码：");
				password2 = input.nextLine();
			}
			System.out.println("请再次确认密码：");
			String password3 = input.nextLine();
			n=0;
			while(!password2.equals(password3)){
				n++;
				if(n>2){
					System.out.println("重设失败！系统返回。");
					break;
				}
				System.out.println("两次输入密码不相同，请重新输入密码：");
				password3 = input.nextLine();
			}
			if(password2.equals(password3)){
				d.admin[uu].setPassword(password3);
				System.out.println("密码重设成功！");
			}
		}else{
			System.out.println("密码输入错误，系统返回！");
		}
		
	}
	//列出管理员名单以及还可建立多少管理员
	private void adminList() {
		int p=0;
		for(int i=0;i<d.admin.length;i++){
			if(d.admin[i].getUsername()!=null){
				System.out.println(d.admin[i].getUsername());
				p++;
			}
		}
		int n = d.admin.length-p;
		System.out.println("还可以建立"+n+"个管理员！");
	}
	//添加到管理员对象
	public void addThis(String name,String password){
		if(j<d.admin.length){
			d.admin[j] = new Admin();
			d.admin[j].setUsername(name);
			d.admin[j].setPassword(password);
			d.admin[j].setId(j);
			System.out.println("添加成功！");
		}else{
			System.out.println("添加失败！管理员已经添加满了！");
		}
		j++;
	}
	
	//判断管理员
	public boolean judgeThis(String name){
		boolean equal = true;
		for(int i=0;i<d.admin.length;i++){
			if(name.equals(d.admin[i].getUsername())){
				System.out.println("管理已经存在！系统返回！");
				equal = false;
				break;
			}
		}
		return equal;
	}
	//账号判断
	public boolean Admin(boolean state){
		if(state) return true;
		Scanner in = new Scanner(System.in);
		boolean equal = false;
		//判断输入账号
		System.out.println("请输入管理员账户：");
		String username = in.nextLine();
		int u=-1;
		int n=0;
		
		//判断输入的管理员用户是否存在
		for(int j=0;j<d.admin.length;j++){
			while(username.equals(d.admin[j].getUsername())&&d.admin[j]!=null){
				equal=true;
				u=j;
				break;
			}
		}
		//证明管理员用户不存在,重新输入
		while(!equal){
			System.out.println("输入的管理账号不存在！请重新输入：");
			username = in.nextLine();
			for(int i=0;i<d.admin.length;i++){
				n++;
				if(n>2){
					System.out.println("账号输错超过三次！系统返回！");
					return false;
				}
				while(username.equals(d.admin[i].getUsername())&&d.admin[j]!=null){
					equal=true;
					u=i;
					break;
				}
			}
			
		}
		
		//判断密码
		if(u!=-1){
			int p=0;
			System.out.println("请输入管理员密码：");
			String password = in.nextLine();
			while(!password.equals(d.admin[u].getPassword())){
				p++;
				if(p>2){
					System.out.println("密码输入错误超过三次！系统返回！");
					return false;
				}
				System.out.println("请重新输入管理员密码：");
				password = in.nextLine();
			}
		}
		//把此管理员号码记录到uu中
		uu=u;
		return true;
	}
	
	//传出admin编号
	public int trans(){
		return uu;
	}
	
}

