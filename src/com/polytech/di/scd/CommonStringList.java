package com.polytech.di.scd;

import java.util.HashSet;

public class CommonStringList {
	private IntString s1;
	private IntString s2;
	private HashSet<CommonString> csl;
	
	CommonStringList(IntString s1, IntString s2){
		this.s1 = s1;
		this.s2 = s2;
		this.csl = new HashSet<CommonString>();
	}
	
	CommonStringList(IntString s){
		this(s, s);
		this.s2.swap(10,  30);
	}
	
	public void constructCommonStringList(){
		for (int i = 0; i < s1.size(); i++){
			for (int j = 0; j < s2.size(); j++){
				if (s1.get(i) == s2.get(j)){
					CommonString temp = new CommonString(i, j, new IntString(s1.subList(i, i+1)));
					
					HashSet<CommonString> buffer = new HashSet<CommonString>();
					
					for(CommonString cs : csl){
						if (cs.get_pos1()+cs.get_tab().size() == i && cs.get_pos2()+cs.get_tab().size() == j){
							IntString concat = new IntString();
							concat.addAll(cs.get_tab());
							concat.add(s1.get(i));
							buffer.add(new CommonString(cs.get_pos1(), cs.get_pos2(), concat));
						}
					}
					
					csl.add(temp);
					csl.addAll(buffer);
				}
			}
		}
	}
	
	public HashSet<CommonString> get_csl(){
		return csl;
	}
}
