package com.polytech.di.scd;

public class CommonString implements Comparable<CommonString>{
	private int pos1;
	private int pos2;
	private IntString tab;
	
	/**
	 * Constructeur d'une sous chaine commune.
	 * @param pos1	position dans la première chaine de la sous chaine commune
	 * @param pos2	position dans la seconde chaine de la sous chaine commune
	 * @param tab	sous chaine commune aux deux chaines
	 */
	public CommonString(int pos1, int pos2, IntString tab){
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.tab = tab;
	}
	
	/**
	 * Sérialise une chaine commune sous forme de chaine de caractères
	 */
	public String toString(){
		return "(\""+tab+"\", "+pos1+", "+pos2+")";
	}
	
	/**
	 * Retourne la position de la sous chaine commune dans la première chaine
	 * @return position de la sous chaine commune dans la première chaine
	 */
	public int get_pos1(){
		return pos1;
	}
	
	/**
	 * Retourne la position de la sous chaine commune dans la seconde chaine
	 * @return position de la sous chaine commune dans la seconde chaine
	 */
	public int get_pos2(){
		return pos2;
	}
	
	/**
	 * Retourne la sous chaine commune
	 * @return sous chaine commune
	 */
	public IntString get_tab(){
		return tab;
	}

	@Override
	/**
	 * Compare deux sous chaine commune
	 * On utilise la même relation d'ordre que IntString sur csl.
	 * Si les deux sous chaines ont la même taille, alors la plus petite sera
	 * celle qui a le plus petit indice de position dans la première chaine.
	 * NB : deux sous chaines ne peuvent être égales, la valeur de retour est 
	 * forcément non nulle.
	 * @param _csl	sous chaine commune à comparer avec this
	 * @return la différence entre les sous chaines communes
	 */
	public int compareTo(CommonString _csl) {
		int tcp=this.tab.compareTo(_csl.tab);
		if(tcp==0)
			return ((this.pos1)-(_csl.pos1));
		return tcp;
	}

}
