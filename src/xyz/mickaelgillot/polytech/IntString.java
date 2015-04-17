package xyz.mickaelgillot.polytech;

import java.util.ArrayList;

public class IntString {
	private ArrayList<Integer> tab;
	
	IntString(ArrayList<Integer> tab){
		this.tab = tab;
	}
	
	IntString(){
		this(new ArrayList<Integer>());
	}
	
	public String toString(){
		return this.tab.toString();
	}
	
	public void exchange(int i, int j){
		if (i != j && i < tab.size() && j < tab.size() && i >= 0 && j >= 0){
			int c = this.tab.get(i);
			tab.set(i,  tab.get(j));
			tab.set(j,  c);
		}
	}
	
	public void swap(int min, int amp){
		int nbIterations = (int) (min + Math.random()*amp);
		
		for (int loop = 0; loop < nbIterations; loop++){
			int i = (int) Math.floor(Math.random()*tab.size());
			int j = (int) Math.floor(Math.random()*tab.size());
			
			exchange(i, j);
		}	
	}
}
