/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

/**
 *
 * @author Brais
 */
public class MatrixFunctions {
    
    
    public static int max(int[][] a) {
        int maxNum = a[1][1];
        for (int i=0; i<a.length ; i++){ 
            for (int ii=0; ii<a[i].length ; ii++){
                if (maxNum<a[i][ii]){
                    maxNum = a[i][ii];
                }
            }
        }
        return maxNum;
    }
    
    public static int rowSum ( int [][] a , int row ) { 
        int sum =0;
        if ( row<a.length ){
            for (int i=0; i<a[row].length; i++){
                sum+= a[row][i];
            }
        }
        return sum;
    }
    
    public static int columnSum(int[][] a , int col){
        int sum =0;
        for (int i=0; i<a.length ; i++) {
            if (col<a[i].length){
                sum+=a[i][col];
            }
        }
        return sum;
    }
    
    public static int [] allRowSums ( int [][] a) { 
        int[] sum =new int[a.length];
        for (int i=0; i<a.length; i++){
            sum[i]=MatrixFunctions.rowSum(a, i);
        }
        return sum;
    }
    
    public static int [] allColumnSums ( int [][] a) { 
        int numCol = a[1].length;
        for (int i=1; i<a.length ; i++ ){
            if (a[i].length>numCol){
                numCol = a[i].length;
            }
        }
        int[] sum = new int[numCol];
        for (int i=0; i<numCol; i++){
            sum[i]=columnSum(a,i);
        }
        return sum;
    }
    
    public static boolean isRowMagic ( int [][] a) { 
        int[] sumas = allRowSums(a);
        for (int i = 1 ; i<sumas.length ; i++){
            if (sumas[i]!=sumas[0]){
                return false;
            }
        }
        return true;
    }
    
    public static boolean isColumnMagic ( int [][] a) { 
        int[] sumas = allColumnSums(a);
        for (int i = 1 ; i<sumas.length ; i++){
            if (sumas[i]!=sumas[0]){
                return false;
            }
        }
        return true;
    }
    
    public static boolean isSquare ( int [][] a) { 
        for (int i=0; i<a.length; i++){
            if (a.length != a[i].length){
                return false;
            }
        }
        return true;
    }
    
    public static boolean isMagic ( int [][] a) { 
        if (rowSum(a,0) != columnSum(a,0)){
            return false;
        }
        if (!(isRowMagic(a) && isColumnMagic(a) && isSquare(a))){
            return false;
        }
        int diagonal1 = 0;
        int diagonal2 = 0;
        
        for (int i =0 ; i<a.length ; i++){  /*realizase a suma das diagonais */
            diagonal1 += a[i][i];
            diagonal2 += a[i][(a.length-1)-i];
        }
        
        return ((diagonal2 == diagonal1) && (diagonal1 == rowSum(a,0)));
    }
    
    
     public static boolean isSequence ( int [][] a) { 
        if (!isSquare(a)){
            return false;
        }
        boolean atopados[] = new boolean[a.length*a.length];
        for (int h = 0 ; h<atopados.length;h++) atopados[h]=false;
        boolean existe = false;
        for (int i = 1 ; i < (a.length) ; i++){ /* recorrese o array */
            for (int j = 0 ; j<a.length ; j++){
                if(atopados[(a[i][j])-1]){      /* se o número xa foi leido en outra posición devolvese false */
                    return false;
                }
                else{                           /* se non foi leido antes gardase que se acaba de leer */
                    atopados[(a[i][j])-1]=true;
                }
            }
        }
        return true;
    }
    
}

