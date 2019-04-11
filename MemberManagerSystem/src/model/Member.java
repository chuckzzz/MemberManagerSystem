/**
 *	@author：     chuck
 *	@version：    2.0版
 *  日期：      2016-9-20下午6:57:15
 */


package model;


public class Member {

	private String name;
	private String number;
	private String bornth;
	private String phoneNumber;
	private String address;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getBornth() {
		return bornth;
	}
	public void setBornth(String bornth) {
		this.bornth = bornth;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void rush() {
		this.name=null;
		this.number=null;
		this.phoneNumber=null;
		this.address=null;
		this.bornth=null;
		this.id=0;
	}
	
	
	
}
