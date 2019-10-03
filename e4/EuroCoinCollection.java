/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e4;

import java.util.HashSet;
/**
 *
 * @author Brais
 */
public class EuroCoinCollection {
    
    private final  HashSet<EuroCoin> coleccion;

    public EuroCoinCollection() {
        this.coleccion = new HashSet<EuroCoin>() {};
    }
    
    
    public boolean insertCoin ( EuroCoin coin ) {
        return coleccion.add(coin);
    }
    
    public boolean hasCoin ( EuroCoin coin ) { 
        return coleccion.contains(coin);
    }

    
    public int value () {
        int suma =0;
        EuroCoin copia[]= new EuroCoin[coleccion.size()];
        copia = coleccion.toArray(copia);
        for (int i=0 ; i<(coleccion.size()) ; i++){
            suma += copia[i].getValor();
        } 
        return suma;
    }
    
    public int numCoins () {
        return coleccion.size();
    }
    
    public void removeCoin ( EuroCoin coin ) {
        coleccion.remove(coin);
    }    
}
    
    