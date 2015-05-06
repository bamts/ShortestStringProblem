package com.polytech.di.scd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ShortestStringProblem {

	public static void main(String[] args) {
		// TODO Stub de la méthode généré automatiquement
		
		//interface pour GLPK � completer ...
		//affiche la version de GLPK
		new Glpk();
		
		if(args==null){
			IntString hint = new IntString(new ArrayList<Integer>(){{
				add(0);
				add(1);
				add(2);
				add(4);
			}});
			
			Generate gen=new Generate(6,hint);
			
			IntString s1 = gen.getS1();
			IntString s2 = gen.getS2();
				
			CommonStringList myListOfCommonString = new CommonStringList(s1, s2);
			
			myListOfCommonString.constructCommonStringList();
			System.out.println(" - "+s1.toString()+"\n - "+s2.toString());
			
			System.out.println(myListOfCommonString.get_csl());
		}
	}
}
