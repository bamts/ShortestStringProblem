package com.polytech.di.scd;

import java.awt.List;
import java.util.ArrayList;

import org.gnu.glpk.*;

public class createProblem {

	public createProblem(boolean[][] m1, boolean[][] m2,String nom) {
		int n = m1.length;//rows
		int m =m1[0].length;//cols
		
		ArrayList<Integer> sum1=new ArrayList<Integer>();
		ArrayList<Integer> sum2=new ArrayList<Integer>();
				
		for(int j = 0 ; j<m ; j++){
			int res1=0;
			int res2=0;
			for(int i = 0 ; i<n ; i++){
				res1+=(m1[i][j] ? 1 : 0);	//convert bool to int
				res2+=(m2[i][j] ? 1 : 0);	//convert bool to int				
			}
			sum1.add(res1);
			sum2.add(res2);
		}
		
        glp_prob lp;
        glp_smcp parm;
        SWIGTYPE_p_int ind;
        SWIGTYPE_p_double val;
        int ret;
        
        try{
        	lp=GLPK.glp_create_prob();
        	GLPK.glp_set_prob_name(lp, nom);
        	System.out.println("Problème de "+ nom + " créé");
        	
        	//colonnes
        	GLPK.glp_add_cols(lp, 2*n);
        	//ajouter une colonne par somme sur une colonne de m1 ( première contrainte )
        	for(int i=1 ; i<=n ; i++){
        		GLPK.glp_set_col_name(lp, i, "S1"+i);
        		GLPK.glp_set_col_kind(lp, i, GLPKConstants.GLP_CV);
        		GLPK.glp_set_col_bnds(lp, i, GLPKConstants.GLP_FX, sum1.get(i-1), 0);//0 ignored car GLP_FX
        	}
        	for(int i=n+1 ; i<=2*n ; i++){
        		GLPK.glp_set_col_name(lp, i, "S2"+(i-n));
        		GLPK.glp_set_col_kind(lp, i, GLPKConstants.GLP_CV);
        		GLPK.glp_set_col_bnds(lp, i, GLPKConstants.GLP_FX, sum2.get(i-n-1), 0);//0 ignored car GLP_FX
        	}
        	
        	//contraintes = lignes
        	
        	ind = GLPK.new_intArray(2*n);//taille de la ligne
        	val = GLPK.new_doubleArray(2*n);
        	
        	GLPK.glp_set_row_name(lp, 1, "X");
        	GLPK.glp_set_row_bnds(lp, 1, GLPKConstants.GLP_DB, 0, 1);//attention 0 ou 1 pas entre 0 et 1
        	for(int i = 1 ; i<=2*n ; i++){
        		GLPK.intArray_setitem(ind, i, i);
        		GLPK.doubleArray_setitem(val, i, 1);        		
        	}
        	GLPK.glp_set_mat_row(lp, 1, 2*n, ind, val);
        	
        	GLPK.delete_intArray(ind);
        	GLPK.delete_doubleArray(val);
        	
        	//objectif
        	GLPK.glp_set_obj_name(lp,"SumX");
        	GLPK.glp_set_obj_dir(lp, GLPKConstants.GLP_MIN);
        	for(int i=1 ; i<=2*n ; i++)
        		GLPK.glp_set_obj_coef(lp, i , 1);
        	
        	//model -> file
        	GLPK.glp_write_lp(lp, null, "Models"+nom.substring(nom.indexOf('\\'))+".lp");
        	
        	//solve
        	
        	parm = new glp_smcp();
        	GLPK.glp_init_smcp(parm);
        	ret = GLPK.glp_simplex(lp, parm);
        	
        	//Recup
        	
        	if(ret == 0){
        		writeSol(lp);
        	}else{
        		writeFailed(lp);
        	}
        	
        	//free
        	GLPK.glp_delete_prob(lp);
        }catch (GlpkException e){
        	e.printStackTrace();
        }
	}

	static void writeSol(glp_prob lp){
		
	}
	static void writeFailed(glp_prob lp){
		
	}
}
