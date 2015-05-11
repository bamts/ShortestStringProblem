package com.polytech.di.scd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IntString extends ArrayList<Integer> implements Comparable<IntString>{
	
	IntString(List<Integer> list){
		super(list);
	}
	
	IntString(String str){ // constructeur avec une String telle que : 1,2,3,4
		String[] vals = str.split(",");
		for(String i : vals){
			this.add(Integer.parseInt(i.trim()));
		}
	}
	
	IntString(){
		super();
	}
	
	@Override
	public IntString clone(){
		return (IntString) super.clone();
		
	}
	
	
	public void exchange(int i, int j){
		if (i != j && i < this.size() && j < this.size() && i >= 0 && j >= 0){
			int c = this.get(i);
			this.set(i,  this.get(j));
			this.set(j,  c);
		}
	}
	
	public void swap(int min, int amp){
		int nbIterations = (int) (min + Math.random()*amp);
		
		for (int loop = 0; loop < nbIterations; loop++){
			int i = (int) Math.floor(Math.random()*this.size());
			int j = (int) Math.floor(Math.random()*this.size());
			
			exchange(i, j);
		}	
	}
	@Override
	public int compareTo(IntString _compare) {
		if(this.size()>_compare.size())
			return -1;
		else if(this.size()<_compare.size())
			return 1;
		else
		return this.toString().compareTo(_compare.toString())+1/this.toString().compareTo(_compare.toString()+1);
	}

}
