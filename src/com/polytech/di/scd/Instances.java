package com.polytech.di.scd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public class Instances {

	String nomDir="Instances\\";
	int count=0;
	File directory;
	public Instances(int nb_instances, int size, IntString hint) {
		
		File root=new File("Instances");
		if(!root.exists()){
			root.mkdir();
		}
		
		nomDir+="Instances_"+nb_instances+"_"+size+"_"+hint;
		
		directory = new File(nomDir);
		
		while(directory.exists()){
			count++;
			directory = new File(nomDir+"_("+count+")");
		}
		if(count>0) nomDir+="_("+count+")";
		directory.mkdir();
		
		for(int i = 1 ; i <= nb_instances ; i++){
			

			Generate gen=new Generate(size,hint);
			IntString s1=gen.getS1();
			IntString s2=gen.getS2();
			CommonStringList myListOfCommonString = new CommonStringList(s1, s2);
			myListOfCommonString.constructCommonStringList();
			
			
			try {
				
				File temp = new File(nomDir+"\\Instance_"+i+".txt");
				temp.createNewFile();
				FileWriter fw=new FileWriter(temp);
				fw.write("S1 : "+s1.toString()+"\n");
				fw.write("S2 : "+s2.toString()+"\n");
				fw.write("Liste des communs:\n");
				fw.write(myListOfCommonString.get_csl().toString());
				fw.write("\n");
				fw.close();				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	
}
