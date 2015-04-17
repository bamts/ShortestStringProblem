package xyz.mickaelgillot.polytech;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ShortestStringProblem {

	public static void main(String[] args) {
		// TODO Stub de la méthode généré automatiquement
		int[] tab = {0, 2, 3, 5, 1, 7, 6};
		
		IntString s = new IntString(new ArrayList<Integer>(){{
			add(0);
			add(2);
			add(3);
			add(5);
			add(1);
			add(7);
			add(6);
		}});
		
		s.swap(10, 30); 
		
		System.out.println(s);
	}

}
