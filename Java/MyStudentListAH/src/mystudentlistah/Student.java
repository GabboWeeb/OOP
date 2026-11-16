/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystudentlistah;

/**
 *
 * @author Antonio
 */
public class Student {
    private String name;//dovrebbero essere property
    private String surname;
    private String code;
    
    // Costruttore vuoto (default)
    public Student() {
    }

    // Costruttore con parametri
    public Student(String name, String surname, String code) {
        this.name = name;
        this.surname = surname;
        this.code = code;
    }

    // Getter e Setter per name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter e Setter per surname
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Getter e Setter per code
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    @Override
    public String toString() {
        return name + " " + surname + " (" + code + ")";
    }   
}