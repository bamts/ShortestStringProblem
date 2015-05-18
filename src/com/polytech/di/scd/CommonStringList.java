package com.polytech.di.scd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class CommonStringList{
	private IntString s1;
	private IntString s2;
	private ArrayList<CommonString> csl;
	
	/**
	 * Constructeur à partir de deux chaines.
	 * Les deux chaines doivent impérativement être des permutations l'une de 
	 * l'autre.
	 * @param s1	première chaine
	 * @param s2	seconde chaine
	 */
	CommonStringList(IntString s1, IntString s2){
		this.s1 = s1;
		this.s2 = s2;
		this.csl = new ArrayList<CommonString>();
	}	
	
	/**
	 * Constructeur à partir d'une chaine modèle.
	 * @param s	chaine modèle
	 */
	CommonStringList(IntString s){
		this(s, s);
		this.s2.swap(10,  30);
	}
	
	/**
	 * Constructeur par défaut.
	 * Créer un problème de taille size à partir de l'alphabet hint.
	 * @param size	taille des chaines à générer
	 * @param hint	alphabet des chaines à générer 
	 */
	CommonStringList(int size, IntString hint){
		this.csl = new ArrayList<CommonString>();
		IntString temp=new IntString();
		int rand;
		
		for(int i=0;i<size;i++){
			rand=(int) (Math.random()*hint.size()+1);
			temp.add(hint.get(rand-1));
			/*
			 * On construit la chaine modèle.
			 */
		}
		
		this.s1=(IntString) temp.clone();
		this.s2=(IntString) temp.clone();
		
		this.s2.swap(2*size, hint.size());
	}
	
	/**
	 * construit la liste des sous chaines communes des deux chaines du problème.
	 */
	public void constructCommonStringList(){
		/*
		 * On parcourt les deux listes.
		 */
		for (int i = 0; i < s1.size(); i++){
			for (int j = 0; j < s2.size(); j++){
				/*
				 * Si on tombe sur un caractère commun, on a donc une nouvelle sous chaine commune.
				 * Cette chaine sera de taille 1, aux positions i et j respectivement,
				 * pour la première chaine et la seconde respectivement.
				 */
				if (s1.get(i) == s2.get(j)){
					CommonString temp = new CommonString(i, j, new IntString(s1.subList(i, i+1)));
					
					ArrayList<CommonString> buffer = new ArrayList<CommonString>();
					
					/*
					 * Cette nouvelle chaine peut nous permettre d'en déduire des nouvelles,
					 * avec celles que l'on a déjà trouvé.
					 * Par exemple : Si on sait que (1, 2, "A") et (2, 3, "B") sont des sous chaines
					 * communes, alors on peut en déduire immédiatement que 
					 * (1, 2, "AB") est également une sous chaine commune.
					 * 
					 * On ne les ajoute pas immédiatement, puisque ces nouvelles
					 * chaines ne peuvent permettre d'en déduire d'autres.
					 * On ne fait des déductions qu'avec la sous chaine (i, j, "x").
					 * De plus, on ne rajoute pas d'éléments dans le tableau qu'on est en train
					 * de parcourir.
					 */
					for(CommonString cs : csl){
						if (cs.get_pos1()+cs.get_tab().size() == i && cs.get_pos2()+cs.get_tab().size() == j){
							IntString concat = new IntString();
							concat.addAll(cs.get_tab());
							concat.add(s1.get(i));
							buffer.add(new CommonString(cs.get_pos1(), cs.get_pos2(), concat));
						}
					}
					
					csl.add(temp);
					csl.addAll(buffer);
				}
			}
		}
		Collections.sort(csl);
	}
	
	/**
	 * Retourne la liste des sous chaines communes.
	 * @return La liste des sous chaines communes.
	 */
	public ArrayList<CommonString> get_csl(){
		return csl;
	}
	
	public IntString get_s1(){
		return this.s1;
	}
	
	public IntString get_s2(){
		return this.s2;
	}

	
}
