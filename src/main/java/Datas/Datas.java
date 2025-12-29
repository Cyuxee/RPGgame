package Datas;

import Entities.Players;

public class Datas{
	private String username;
	private String password;
	private int index;
	public Datas(Players player) {
		username="12345";//預設的帳號密碼
		password="12345";
		index = 0;
	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
