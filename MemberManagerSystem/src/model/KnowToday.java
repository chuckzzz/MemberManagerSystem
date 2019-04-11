package model;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *@author：     chuck
 *@version：    2.0版
 *     日期：      2016-9-6下午4:53:22
 */

public class KnowToday {
	private int year;
	private int mon;
	private int day;
	
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMon() {
		return mon;
	}

	public void setMon(int mon) {
		this.mon = mon;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public boolean jugdeToday() throws InputMismatchException{
		
		//定义月份天数数组
		
		int[] month = new int[12];
		Scanner in =new Scanner(System.in);
		System.out.println("请输入会员生日，年份(1900-2020年)：");
		
		//判断年份的字符问题
		String Year;
		st:while(true){
			Year = in.nextLine();
			if ("".equals(Year)) {
				System.out.println("年份不能为空,请重新输入:");
				continue;
			}
			Pattern p_str = Pattern.compile("[0-9]+");
			Matcher m = p_str.matcher(Year);
			if (m.find() && m.group(0).equals(Year)) {
				year = Integer.parseInt(Year);
				//判断输入年是否有误
				
				while(year>2020||year<1900){
					System.out.println("输入的年份不符合要求！！请重新输入：");
					continue st;
				}
				break;
			}else{
				System.out.println("里面有其他字符,不符合数字，请重新输入:");
				continue st;
			}
			
		
		}
		
	
	
		//初始化月份的天数值
		
		pr(year,month);
		
		//月份判断
		System.out.println("请输入月份：");
		String Mon;
		st:while(true){
			Mon= in.nextLine();
			if ("".equals(Mon)) {
				System.out.println("月份不能为空,请重新输入:");
				continue st;
			}
			Pattern p_str = Pattern.compile("[0-9]+");
			Matcher m = p_str.matcher(Mon);
			if (m.find() && m.group(0).equals(Mon)) {
				mon = Integer.parseInt(Mon);
				//判断输入月是否有误
				while(mon>12||mon<=0){
					System.out.println("输入的月份不符合人类的一年12个月！！请重新输入：");
					continue st;
				}
				break;
			}else{
				System.out.println("里面有其他字符,不符合数字，请重新输入:");
				continue st;
			}
		}
		

		
		
		//再加上输入的日期天数
		
		System.out.println("请输入日期：");
		String Day = null;
		
		//判断日期是否有误
		st:while(true){
			Day= in.nextLine();
			if (Day.equals("")) {
				System.out.println("日期不能为空,请重新输入:");
				continue st;
			}
			Pattern p_str = Pattern.compile("[0-9]+");
			Matcher m = p_str.matcher(Day);
			if (m.find() && m.group(0).equals(Day)) {
				day = Integer.parseInt(Day);
				//2月份特殊，判断年是否为闰年
				if(mon==2){
					if(year%4==0&&year%100!=0||year%400==0){
						while(day<=0||day>29){
							System.out.println("输入的日期有问题！！请重新输入：");
							continue st;
						}
					}else{
						while(day<=0||day>28){
							System.out.println("输入的日期有问题！！请重新输入：");
							continue st;
						}
					}
					
				//判断1、3、5、7、8、10、12月的天数
				}else if(mon==1||mon==3||mon==5||mon==7||mon==8||mon==10||mon==12){
					
					while(day<=0||day>31){
						System.out.println("输入的日期有问题！！请重新输入：");
						continue st;
					}
				//判断4、6、9、11月的天数
				}else if(mon==4||mon==6||mon==9||mon==11){
					while(day<=0||day>30){
						System.out.println("输入的日期有问题！！请重新输入：");
						continue st;
					}
				}
				break;
			}else{
				System.out.println("里面有其他字符,不符合数字，请重新输入:");
				continue st;
			}
		}
	
		System.out.println("Ok!");
		return true;
	}
	
	//初始值月份天数的方法
	
	private void pr(int year,int[] month){
		if(year%4==0&&year%100!=0||year%400==0){
			
			month[1] = 29;
		}else{
			month[1] = 28;
		}
		month[0] = 31;
		month[2] = 31;
		month[4] = 31;
		month[6] = 31;
		month[7] = 31;
		month[9] = 31;
		month[11] = 31;
		month[3] = month[5] = month[8] = month[10] = 30;
	}

}
