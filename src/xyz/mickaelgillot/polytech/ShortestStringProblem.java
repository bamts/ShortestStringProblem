package xyz.mickaelgillot.polytech;

import java.util.HashSet;
import java.util.Set;

public class ShortestStringProblem {
	
	public static String changeChar(String s, int pos, char c){
		return s.substring(0, pos)+c+s.substring(pos+1);
	}
	
	public static String swap(String s){
		int i = (int) Math.floor((Math.random() * s.length()));
		int j = (int) Math.floor((Math.random() * s.length()));
				
		char c = s.charAt(i);
		
		s = changeChar(s, i, s.charAt(j));
		s = changeChar(s, j, c);
		
		return s;
	}
	
	public static String permut(String s, int min, int amplitude){
		String res = s;
		
		int nbIterations = (int) (min + (Math.random() * amplitude));
		
		for (int i = 0; i < nbIterations; i++){
			res = swap(res);
		}
		return res;
	}
	
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
		
		//Set<CommonString> result = monome(s1, s2);
		String s = "ABCDEFGHI";
		System.out.println(permut(s, 10, 10));
		
		//System.out.println(result);		
	}

}
