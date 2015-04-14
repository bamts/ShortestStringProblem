package xyz.mickaelgillot.polytech;

public class CommonString {
	private int pos1;
	private int pos2;
	private String s;
	
	public CommonString(int pos1, int pos2, String s){
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.s = s;
	}
	
	public String toString(){
		return "(\""+s+"\", "+pos1+", "+pos2+")";
	}
	
	public int compare(CommonString c){
		return s.compareTo(c.s);
	}
}
