package xyz.mickaelgillot.polytech;

public class CommonString {
	private int pos1;
	private int pos2;
	private IntString tab;
	
	public CommonString(int pos1, int pos2, IntString tab){
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.tab = tab;
	}
	
	public String toString(){
		return "(\""+tab+"\", "+pos1+", "+pos2+")";
	}
}
