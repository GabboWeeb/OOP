/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneaeromobili;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabri
 */
public class Aeroporto implements Serializable {
    private final Map<String, Aeromobile> aeromobili;
    private final CodeChecker checker;
    
    public Aeroporto(CodeChecker checker) {
        aeromobili = new LinkedHashMap<>();
        this.checker = checker;
    }
    
    public boolean inserisci(Aeromobile a) {
        if(checker == null) {
            aeromobili.put(a.getCodice(), a);
            return true;
        }
        if(checker.check(a.getCodice())) {
            aeromobili.put(a.getCodice(), a);
            return true;
        }
        return false;
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
        for(Aeromobile a : al) {
            sb.append(a.toString()).append("\n");
        }
        return sb.toString();
    }
    
    public void salvaDOS(String nomefile) {
        try(DataOutputStream dos = new DataOutputStream(
            new BufferedOutputStream(
                new FileOutputStream(nomefile)))) {
            
            dos.writeInt(aeromobili.size());

            for (Aeromobile a : aeromobili.values()) {
                // Identifico il tipo concreto (utile se Aeromobile ha sottoclassi)
                dos.writeUTF(a.getClass().getSimpleName());
                
                // Salvo gli attributi comuni di Aeromobile
                dos.writeUTF(a.getCodice());
                

                // 3. Se esistono sottoclassi, salvo gli attributi specifici
                if (a instanceof AereoAMotore) {
                    AereoAMotore am = (AereoAMotore) a;
                    dos.writeInt(am.getNumRotori());
                } else if (a instanceof Aliante) {
                    Aliante al = (Aliante) a;
                    dos.writeDouble(al.getEfficienza());
                }
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static Aeroporto leggiDIS(String nomefile) {
        Aeroporto ap = new Aeroporto(null);
        
        try(DataInputStream dis = new DataInputStream(
            new BufferedInputStream(
                new FileInputStream(new File(nomefile))))) {
            
            int numeroAerei = dis.readInt();
            
            for(int i=0;i<numeroAerei;i++) {
                String tipologia = dis.readUTF();
                String codice = dis.readUTF();
                
                if(AereoAMotore.class.getSimpleName().equals(tipologia)) {
                    int numRotori = dis.readInt();
                    ap.inserisci(new AereoAMotore(codice,numRotori));
                } else if(Aliante.class.getSimpleName().equals(tipologia)) {
                    double efficienza = dis.readDouble();
                    ap.inserisci(new Aliante(codice,efficienza));
                }
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
            ap = null;
        }
        
        return ap;
    }
    
    public void salvaOBJ(String nomefile) {
        try(FileOutputStream obj = new FileOutputStream(new File(nomefile));
                ObjectOutputStream st = new ObjectOutputStream(obj)) {
            
            st.writeObject(this);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static Aeroporto leggiOBJ(String nomefile) {
        Aeroporto ap = new Aeroporto(null);
        
        try(FileInputStream obj = new FileInputStream(new File(nomefile));
                ObjectInputStream st = new ObjectInputStream(obj)) {
            
            ap = (Aeroporto)st.readObject();
            
        } catch (IOException ex) {
            ex.printStackTrace();
            ap = null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Aeroporto.class.getName()).log(Level.SEVERE, null, ex);
            ap = null;
        }
        
        return ap;
    }
}
