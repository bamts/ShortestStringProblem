package com.polytech.di.scd;
import org.gnu.glpk.GLPK;

public class Glpk {
	String version=GLPK.glp_version();
	public Glpk(){
		System.out.println(version);
	}
}
