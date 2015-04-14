package xyz.mickaelgillot.polytech;

import java.util.HashSet;
import java.util.Set;

public class ShortestStringProblem {
	
	public static Set<CommonString> monome(String s1, String s2){
		Set<CommonString> res = new HashSet<CommonString>();
		
		for (int i = 0; i < s1.length(); i++){
			for (int j = 0; j < s2.length(); j++){
				if (Character.compare(s1.charAt(i), s2.charAt(j)) == 0){
					res.add(new CommonString(i, j, s1.substring(i, i+1)));
				}
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Stub de la méthode généré automatiquement
		String s1 = "ACTGAGT";
		String s2 = "TATACGG";
		
		Set<CommonString> result = monome(s1, s2);
		
		System.out.println(result);
		
	}

}
