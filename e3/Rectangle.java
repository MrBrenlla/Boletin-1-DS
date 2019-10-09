/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e3;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.*;
/**
 *
 * @author lorudarkuh
 */
// Represents a rectangle
public class Rectangle {
    
    private int base;
    private int height;
    
    //Inicializa un nuevo rectángulo con los valores pasados​por parámetro.
    // Lanza IllegalArgumentException si se pasa un valor negativo a cualquiera de
    // las dimensiones .
    public Rectangle ( int base , int height ) { 
        if ((base < 0) || (height < 0))
            throw new IllegalArgumentException("Introduciuse un valor negativo");
        
        this.base = base;
        this.height = height;
        
    }
    // Copy constructor
    public Rectangle ( Rectangle r ) { 
        this.base = r.base;
        this.height = r.height;
    }
    // Getters
    
    public int getBase () { 
        return base;
    }
    
    public int getHeight () {
        return height;
    }
    
    // Setters . Throw IllegalArgumentException if the parameters are negative .
    public void setBase ( int base ) { 
        if (base < 0)
            throw new IllegalArgumentException("Introduciuse un valor negativo");
        this.base = base;
        
    }
    
    public void setHeight ( int height ) { 
        if (this.height < 0)
            throw new IllegalArgumentException("Introduciuse un valor negativo");
        this.height = height;
    }
    
    // Return true if the rectangle is a square
    public boolean isSquare () {
        return this.base == this.height;
    }
    
    // Calculate the area of the rectangle .
    public int area () { 
        return base * height;
    }
    
    // Calculate the perimeter of the rectangle .
    public int perimeter () { 
        return 2*base + 2*height;
    }
    
    // Calculate the length of the diagonal
    public double diagonal () {
        return Math.sqrt(pow(base,2) + pow(height,2));
    }
    
    // Turn this rectangle 90 degrees ( changing base by height ).
    public void turn () {
        int aux = this.base;
        this.base = this.height;
        this.height = aux;
    }
    
    // Ensure that this rectangle is oriented horizontally ( the base is greater
    // or equal than the height ).
    public void putHorizontal () { 
        if (base < height) {
            int aux = base;
            base = height;
            height = aux;
        }
    }
    
    // Ensure that this rectangle is oriented vertically ( the height is greater
    // or equal than the base ).
    public void putVertical () { 
        if (this.base > this.height) {
            int aux = this.base;
            this.base = this.height;
            this.height = aux;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.base + this.height;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rectangle other = (Rectangle) obj;
        
        return (this.base==other.base && this.height == other.height) || (this.base == other.height && this.height==other.base);
    }
    
    
}
