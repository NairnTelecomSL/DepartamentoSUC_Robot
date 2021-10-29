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
public class Registro {
    private final String numero_SUC;
    private final String miga;
    private final String estado;
    private final String identificador; //PUEDE SER VACÍO
    private final String uso;           //PUEDE SER VACÍO
    private final String cable;         //PUEDE SER VACÍO
    private final String elementoPasivo;//PUEDE SER VACÍO
    private final String ipid_id;       //PUEDE SER VACÍO
    
    public Registro(String numero_SUC, String miga, String estado, String identificador, String uso, String cable, String elementoPasivo, String ipid_id){
        this.elementoPasivo = elementoPasivo;
        this.estado = estado;
        this.identificador = identificador;
        this.ipid_id = ipid_id;
        this.miga = miga;
        this.numero_SUC = numero_SUC;
        this.uso = uso;
        this.cable = cable;
    }

    public String getNumeroSUC(){
        return this.numero_SUC;
    }
    
    public String getMiga(){
        return this.miga;
    }
    
    public String getEstado(){
        return this.estado;
    }
    
    public String getIdentificador(){
        return this.identificador;
    }
    
    public String getUso(){
        return this.uso;
    }
    
    public String getElementoPasivo(){
        return this.elementoPasivo;
    }
    
    public String getIPIDID(){
        return this.ipid_id;
    }
    
    public String getCable(){
        return this.cable;
    }
    
    public boolean compare(Registro registro){
        return registro.numero_SUC.equals(this.numero_SUC) && 
               registro.identificador.equals(this.identificador) && 
               registro.ipid_id.equals(this.ipid_id);
    }
    
    public static boolean compare(Registro r1, Registro r2){
        return r1.getNumeroSUC().equals(r2.getNumeroSUC()) && 
               r1.getIdentificador().equals(r2.getIdentificador()) && 
               r1.getIPIDID().equals(r2.getIPIDID());
    }
    
    @Override
    public String toString(){
        return "Nº SUC: " + this.numero_SUC + 
                "\nMiga: " + this.miga + 
                "\nEstado: " + this.estado +
                "\nIdentificador: " + this.identificador +
                "\nUso: " + this.uso +
                "\nCable: " + this.cable +
                "\nElemento: " + this.elementoPasivo + 
                "\nIDPID: " + this.ipid_id;
    }
}
