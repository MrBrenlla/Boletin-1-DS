/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

import java.util.*;

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
        for (int i=0; i<a[row].length; i++){
            sum+= a[row][i];
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
        boolean existe = false;
        for (int num = 1 ; num < (a.length*a.length) ; num++){ /*Calculase o numero a buscar*/
            for (int i = 0 ; i<a.length ; i++){
                for (int ii = 0 ; ii<a.length ; ii++){ /*Recorrese o array*/
                    
                    if ((a[i][ii] == num) && (existe)){ /* Comprobase que non apareza o numero unha segunda vez, pois esto significaria que non é unha secuencia, o que poderia simplificar a execución en arrays grandes*/
                        return false;
                    }
                    if (a[i][ii] == num){ /*Comprobase se o numero actual é o buscado*/
                        existe = true;
                    }
                }
            }
            if (!(existe)){
                return false;
            }
            existe=false;
        }
        return true;
    }
    
    public static void main(String[] args){ /* O main é unha comprobación para comprobar que todo funciona, non é parte do traballo a enviar*/
        int[][] A;
        A = new int[3][];
        A[0] = new int[3];
        A[1] = new int[3];
        A[2] = new int[3];
        
        for (int i=0; i<A.length ; i++){
            int alto = A[i].length;
            for (int ii=0; ii<alto ; ii++){
                A[i][ii]=i+1+ii*3;
            }
        }
        
        System.out.println("O máximo é: " + MatrixFunctions.max(A));
        System.out.println("A suma da fila 0 é : " + MatrixFunctions.rowSum(A , 0));
        System.out.println("A suma da fila 1 é : " + MatrixFunctions.rowSum(A , 1));
        System.out.println("A suma da fila 2 é : " + MatrixFunctions.rowSum(A , 2));
        System.out.println("A suma da columna 0 é : " + MatrixFunctions.columnSum(A , 0));
        System.out.println("A suma da columna 1 é : " + MatrixFunctions.columnSum(A , 1));
        System.out.println("A suma da columna 2 é : " + MatrixFunctions.columnSum(A , 2));
        System.out.println("A suma das filas é : " + MatrixFunctions.allRowSums(A)[0]+" "+MatrixFunctions.allRowSums(A)[1]+" "+MatrixFunctions.allRowSums(A)[2]);
        System.out.println("A suma das columnas é : " + MatrixFunctions.allColumnSums(A)[0]+" "+MatrixFunctions.allColumnSums(A)[1]+" "+MatrixFunctions.allColumnSums(A)[2]);
        System.out.println("Filas máxicas: " + MatrixFunctions.isRowMagic(A));
        System.out.println("Columnas máxicas: " + MatrixFunctions.isColumnMagic(A));
        System.out.println("É cadrada: " + MatrixFunctions.isSquare(A));
        System.out.println("É máxico: " + MatrixFunctions.isMagic(A));
        System.out.println("É unha secuencia: " + MatrixFunctions.isSequence(A));
    }
}

