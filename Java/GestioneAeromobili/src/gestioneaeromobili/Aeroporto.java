/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneaeromobili;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author gabri
 */
public class Aeroporto implements Serializable {
    private final Map<String, Aeromobile> aeromobili;
    private final CodeChecker checker;
    
    public Aeroporto(CodeChecker checker) {
        aeromobili = new 
        this.checker = checker;
    }
    
    public Aeromobile cerca(String codice) {
        if(aeromobili.containsKey(codice)) {
            try {
                Aeromobile aeromobile = aeromobili.get(codice);
                return (Aeromobile) aeromobile.clone();
            } catch(CloneNotSupportedException ex) {
                return null;
            }
        }
        return null;
    }
    
    public Aeromobile rimuovi(String codice) {
        if(aeromobili.containsKey(codice)) {
            return aeromobili.remove(codice);
        }
        return null;
    }
    
    public int elementi() {
        return aeromobili.size();
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        ArrayList<Aeromobile> al = new ArrayList<>(aeromobili.values());
    }
}
