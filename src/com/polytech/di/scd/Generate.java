package com.polytech.di.scd;

public class Generate {
	IntString s1,s2;
	
	public Generate(int size,IntString hint){
		IntString temp=new IntString();
		int rand;
		for(int i=0;i<size;i++){
			rand=(int) (Math.random()*hint.size()+1);
			temp.add(hint.get(rand-1));
		}
		s1=temp.clone();
		s2=temp.clone();
		s2.swap(size, hint.size());
	}
	public IntString getS1(){
		return s1;
	}
	public IntString getS2(){
		return s2;
	}
}
