/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2;


import java.util.*;
/**
 *
 * @author lorudarkuh
 */

    
public class Polymers {
    
    
    /*** Given a polymer  represented  with  the  letters  of the  alphabet (uppercase
     * and  lowercase  excluding~N), it  processes  the  chain  reactions  of said
     * polymer (due to  adjoint  units of the  same  type  but  different  polarity ,
     * for  example: aA).
     * It  returns  the  polymer  without  the  reactive  pairs (it can be an empty
     * string) and it  throws  an  IllegalArgumentException  if the  String  passed
     * as  parameter  is null.
     * @param polymer
     * @return 
     * 
     * Dado un polímero representado con las letras del alfabeto (mayúsculas
     * y minúsculas excluyendo ~ N), procesa las reacciones en cadena de dicho
     * polímero (debido a unidades contiguas del mismo tipo pero de polaridad diferente,
     * por ejemplo: aA).
     * Devuelve el polímero sin los pares reactivos (puede ser un vacío
     * cadena) y arroja una IllegalArgumentException si la cadena pasó
     * como parámetro es nulo.
     */
    public static String processPolymer( String polymer ) { 
            if (polymer == null){
                throw new IllegalArgumentException("Non pasaches un polímero");
            }
            StringBuilder array = new StringBuilder(polymer);
            for (int i = 0; i< array.length(); i++){
                if (i != 0){
                    char aux1 = array.charAt(i);
                    char aux2 = array.charAt(i-1);
                    if ((aux1 != aux2) && ((Character.toUpperCase(aux2) == aux1 ) || (Character.toUpperCase(aux1) == aux2))){
                        array.delete(i-1, i+1);
                        i = i-2;
                    }
                    
                }
            }
            
            String newPolymer = "";
            for (int i = 0; i < array.length(); i++){
               newPolymer = newPolymer + array.charAt(i);
            }
            return newPolymer;
    }
    
    
    /*** Given a polymer  returns  the  monomer (existing  in the  polymer) whose
     * elimination (both in its  positive  and  negative  form) results , after  the
     * consequent  chain  reactions , in the  smallest  polymer.
     * It  returns  the  positive  form (lowercase) of the  monomer. In case of a
     * tie , the  one  with  the  lowest  alphabetical  order  is  returned.
     * An  IllegalArgumentException  is  thrown  if the  original  polymer  is null or
     * if it is a empty  string.
     * @param polymer
     * @return 
     * 
     * Dado un polímero devuelve el monómero (existente en el polímero) cuyo
     * resultados de eliminación (tanto en su forma positiva como negativa), después de la
     * reacciones en cadena consecuentes, en el polímero más pequeño.
     * Devuelve la forma positiva (minúscula) del monómero. En caso de un
     * empate, se devuelve el que tiene el orden alfabético más bajo.
     * Se produce una IllegalArgumentException si el polímero original es nulo o
     * si es una cadena vacía.
     */
    public  static  char  minProcessedPolymer(String  polymer) {
        if ((polymer == null) || (polymer.isEmpty())) 
            throw new IllegalArgumentException("Non é un polímero válido");
        StringBuilder aux1 = new StringBuilder(polymer);
        String aux2 = "";
        String anterior = "";
        char min = 'A';
        for (int i = 0; i<polymer.length();i++) {
            char letra = polymer.charAt(i);
            for (int j = 0; j<aux1.length(); j++) {
                char letra2 = aux1.charAt(j);
                if ((Character.toLowerCase(letra) == letra2) || (Character.toUpperCase(letra) == letra2)) {
                    aux1.deleteCharAt(j);
                    j = j - 1;
                }
            }
            
            aux2 = processPolymer(aux1.toString());
            if (i==0) {
                anterior = aux2;
                min = letra;
            } else if ((i!=0) && (aux2.length()<anterior.length()) ) {
                anterior = aux2;
                min = letra;
                
            }
            aux1 = new StringBuilder(polymer);
        }
        return min;

    }
        
        
    
}

