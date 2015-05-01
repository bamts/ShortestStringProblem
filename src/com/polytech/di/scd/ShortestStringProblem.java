package com.polytech.di.scd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ShortestStringProblem {

	public static void main(String[] args) {
		// TODO Stub de la méthode généré automatiquement
		
		IntString s1 = new IntString(new ArrayList<Integer>(){{
			add(0);
			add(1);
			add(2);
			add(3);
		}});
		
		IntString s2 = new IntString(new ArrayList<Integer>(){{
			add(1);
			add(2);
			add(3);
			add(0);
		}});
		
		CommonStringList myListOfCommonString = new CommonStringList(s1, s2);
		
		myListOfCommonString.constructCommonStringList();
		
		System.out.println(myListOfCommonString.get_csl());
	}

}
