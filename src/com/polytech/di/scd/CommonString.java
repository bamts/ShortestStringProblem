package com.polytech.di.scd;

public class CommonString {
	private int pos1;
	private int pos2;
	private IntString tab;
	
	public CommonString(int pos1, int pos2, IntString tab){
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.tab = tab;
	}
	
	public String toString(){
		return "(\""+tab+"\", "+pos1+", "+pos2+")";
	}
	
	public int get_pos1(){
		return pos1;
	}
	
	public int get_pos2(){
		return pos2;
	}
	
	public IntString get_tab(){
		return tab;
	}
}
