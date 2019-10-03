/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e4;

/**
 *
 * @author Brais
 */
public enum Pais{
   AUSTRIA("AT"),BELGIUM("BE"),CYPRUS("CY"),NETHERLANDS("NL"),ESTONIA("EE"),FINLAND("FI"),FRANCE("FR"),
   GERMANY("DE"),GREECE("GR"),IRELAND("IE"),ITALY("IT"),LATVIA("LV"),LITHUANIA("LT"),LUXEMBOURG("LU"),
   MALTA("MT"),MONACO("MC"),PORTUGAL("PT"),SAN_MARINO("SM"),SLOVAKIA("SK"),SLOVENIA("SI"),SPAIN("ES"),
   VATICAN_CITY("VA");
   
    private final String code;
    

    Pais(String code){
        this.code=code;
    }
    
}

