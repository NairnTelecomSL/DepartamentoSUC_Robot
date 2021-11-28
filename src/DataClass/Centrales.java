/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataClass;

/**
 *
 * @author Álvaro Rofa Aranda
 */
public class Centrales {
    private final String poblacion;
    private final String miga;
    private final String nombreCT;
    private final String provMun;
    private final String nombre;
    
    public Centrales(String poblacion,String miga, String nombreCT,String provMun,String nombre){
        this.miga = miga;
        this.nombre = nombre;
        this.nombreCT = nombreCT;
        this.poblacion = poblacion;
        this.provMun = provMun;
    }
    
    public String getPoblacion() {
        return poblacion;
    }

    public String getMiga() {
        return miga;
    }

    public String getNombreCT() {
        return nombreCT;
    }

    public String getProvMun() {
        return provMun;
    }

    public String getNombre() {
        return nombre;
    }
    
    @Override
    public String toString() {
        return "POB: " + this.poblacion +"\nMIGA: " + this.miga + "\nNOMCT: " + this.nombreCT + "\nPROV: " + this.provMun + "\nNOMBR: " + this.nombre;
    }
    
    
}
