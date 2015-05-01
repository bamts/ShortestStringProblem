package com.polytech.di.scd;

import java.util.ArrayList;
import java.util.List;

public class IntString extends ArrayList<Integer> {
	
	IntString(List<Integer> list){
		super(list);
	}
	
	IntString(){
		super();
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
}
