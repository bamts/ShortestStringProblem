package com.polytech.di.scd;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ShortestStringProblem {

	public static void main(String[] args) {
		// TODO Stub de la méthode généré automatiquement
		
		//interface pour GLPK � completer ...
		//affiche la version de GLPK
		//new Glpk();
	
		IntString hint = new IntString(new ArrayList<Integer>(){{
			add(0);
			add(1);
			add(2);
			add(4);
		}});
		
		new Instances(10,6,hint);
		
		
		
	}
}
