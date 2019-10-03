package e4;

import static e4.Color.*;
import static e4.Pais.*;
import java.util.Objects;

public class EuroCoin {
    private final int valor;
    private final Color color;
    private final Pais pais;
    private final String diseño;
    private final int año;

    public EuroCoin(int valor, String diseño, int año, Color color, Pais pais) {
        this.valor = valor;
        this.color = color;
        this.pais = pais;
        this.diseño = diseño;
        this.año = año;
    }



    public int getValor() {
        return valor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final EuroCoin other = (EuroCoin) obj;
        if (this.valor != other.valor) {
            return false;
        }
        if (!Objects.equals(this.diseño, other.diseño)) {
            return false;
        }
        if (this.color != other.color) {
            return false;
        }
        if (this.pais != other.pais) {
            return false;
        }
        return true;
    }
    
    
}
