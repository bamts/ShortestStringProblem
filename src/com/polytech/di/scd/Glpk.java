package com.polytech.di.scd;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

public class Glpk {
	File rep= new File("Instances\\");
	
	public Glpk(){
		File[] instances = rep.listFiles();
		for (File f : instances) {
			File[] current = f.listFiles();
				String[] fields=f.getName().split("_");
				int size= Integer.parseInt(fields[2]);
				String alphabet = fields[3];
				
			for (File file : current) {
				try {
					Scanner reader = new Scanner(file);
					IntString[] datas = readDatas(reader);
					
					String[] B=readB(reader);
					boolean[][] M1 = new boolean[B.length][size];
					boolean[][] M2 = new boolean[B.length][size];
					int i=0;
					for (String str : B) {
						
						String[] tab_pos = str.split("\"");
						
						IntString tab = new IntString(tab_pos[1].substring(tab_pos[1].indexOf('[')+1, tab_pos[1].indexOf(']')));
						
						int pos1=Integer.parseInt(tab_pos[2].substring(tab_pos[2].indexOf(' ')+1, tab_pos[2].lastIndexOf(',')));
						int pos2=Integer.parseInt(tab_pos[2].substring(tab_pos[2].lastIndexOf(',')+2));
												
						for(int j=0;j<size;j++){
							M1[i][j]=(j>=pos1 && j-pos1<tab.size());
							M2[i][j]=(j>=pos2 && j-pos2<tab.size());
						}
												
						i++;
						
					}					
					new createProblem(M1,M2,file.getName());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
	}


	private String[] readB(Scanner reader) {
		String res=reader.nextLine();
		
		res = res.substring(res.indexOf('[')+1, res.lastIndexOf(']'));
		String[] B_str=res.split("\\)");
		return B_str;
	}

	private IntString[] readDatas(Scanner reader){
	
		String res=reader.nextLine();
		res = res.substring(res.indexOf('[')+1,res.indexOf(']'));
		IntString s1 = new IntString(res);
		
		res=reader.nextLine();
		res = res.substring(res.indexOf('[')+1,res.indexOf(']'));
		IntString s2 = new IntString(res);
		
		reader.nextLine();
		  
		return new IntString[]{s1,s2};
	
	}
		
	
}
