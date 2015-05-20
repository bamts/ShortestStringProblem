package com.polytech.di.scd;

import java.awt.List;
import java.util.ArrayList;

import org.gnu.glpk.*;

public class createProblem {

	public createProblem(boolean[][] m1, boolean[][] m2,String nom) {
		int n = m1.length;//rows
		int m =m1[0].length;//cols
		
//		ArrayList<Integer> sum1=new ArrayList<Integer>();
//		ArrayList<Integer> sum2=new ArrayList<Integer>();
//				
//		for(int j = 0 ; j<m ; j++){
//			int res1=0;
//			int res2=0;
//			for(int i = 0 ; i<n ; i++){
//				res1+=(m1[i][j] ? 1 : 0);
//				res2+=(m2[i][j] ? 1 : 0);		
//			}
//			sum1.add(res1);
//			sum2.add(res2);
//		}
		
        glp_prob lp;
        glp_smcp parm;
        SWIGTYPE_p_int ind;
        SWIGTYPE_p_double val;
        int ret;
        
        try{
        	lp=GLPK.glp_create_prob();
        	GLPK.glp_set_prob_name(lp, nom);
        	System.out.println("Problème de "+ nom + " crée");
        	
        	//colonnes
        	GLPK.glp_add_cols(lp, n+1);
        	//xi in 0..n
        	for(int i=1 ; i<=n ; i++){
        		GLPK.glp_set_col_name(lp, i, "X"+i);
        		GLPK.glp_set_col_kind(lp, i, GLPKConstants.GLP_BV);
        		GLPK.glp_set_col_bnds(lp, i, GLPKConstants.GLP_DB, 0, 1);
        	}
        	
        	//contraintes = lignes
        	
        	ind = GLPK.new_intArray(n+1);//taille de la ligne
        	val = GLPK.new_doubleArray(n+1);

            GLPK.glp_add_rows(lp, m+1);//m contraintes pour M1
        	for(int j=1 ; j<=m ; j++){
        	GLPK.glp_set_row_name(lp, j, "S1"+(j-1));
        	GLPK.glp_set_row_bnds(lp, j, GLPKConstants.GLP_FX , 1, 1);
	        	for(int i=1 ; i<=n ; i++){
	        		GLPK.intArray_setitem(ind, i, i);
	        		GLPK.doubleArray_setitem(val, i, m1[i-1][j-1] ? 1 : 0);	//cast bool to int		
        		}
	        GLPK.glp_set_mat_row(lp, j, n, ind, val);
	                	
        	}
            GLPK.glp_add_rows(lp, m+1);//m contraintes pour M2
        	for(int j=1 ; j<=m ; j++){
        	GLPK.glp_set_row_name(lp, j+m, "S2"+(j-1));
        	GLPK.glp_set_row_bnds(lp, j+m, GLPKConstants.GLP_FX, 1, 1);
        		for(int i=1 ; i<=n ; i++){
	        		GLPK.intArray_setitem(ind, i, i);
	        		GLPK.doubleArray_setitem(val, i, m2[i-1][j-1] ? 1 : 0);     
        		}
            GLPK.glp_set_mat_row(lp, j+m, n, ind, val);
            	
        	}
        	
        	GLPK.delete_intArray(ind);
        	GLPK.delete_doubleArray(val);
        	
        	//objectif
        	GLPK.glp_set_obj_name(lp,"SumX");
        	GLPK.glp_set_obj_dir(lp, GLPKConstants.GLP_MIN);
        	for(int i=1 ; i<=n ; i++)
        		GLPK.glp_set_obj_coef(lp, i , 1);
        	
        	//model -> file
        	GLPK.glp_write_lp(lp, null, "Models//"+nom.substring(0,nom.indexOf('.'))+".lp");
        	
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
        int i;
        int n;
        String name;
        double val;

        name = GLPK.glp_get_obj_name(lp);
        val = GLPK.glp_get_obj_val(lp);
        System.out.print(name);
        System.out.print(" = ");
        System.out.println(val);
        n = GLPK.glp_get_num_cols(lp);
        for (i = 1; i <= n; i++) {
            name = GLPK.glp_get_col_name(lp, i);
            val = GLPK.glp_get_col_prim(lp, i);
            System.out.print(name);
            System.out.print(" = ");
            System.out.println(val);
        }
		
	}
	static void writeFailed(glp_prob lp){
        int i;
        int n;
        String name;
        double val;

        name = GLPK.glp_get_obj_name(lp);
        val = GLPK.glp_get_obj_val(lp);
        System.out.print(name);
        System.out.print(" = ");
        System.out.println(val);
        n = GLPK.glp_get_num_cols(lp);
        for (i = 1; i <= n; i++) {
            name = GLPK.glp_get_col_name(lp, i);
            val = GLPK.glp_get_col_prim(lp, i);
            System.out.print(name);
            System.out.print(" = ");
            System.out.println(val);
        }
	}
}
