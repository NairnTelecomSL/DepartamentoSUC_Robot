/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassApplication;

import AppInterface.SolicitudAWindow;
import DataClass.Registro;
import Exceptions.NoRelationshipException;
import Exceptions.SolicitudAException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Álvaro Rofa Aranda
 */
public final class RegistroApplication {
    public RegistroApplication(){}
       
    /***
     * Devuelve los nº de suc que estén relacionados entre los dos registros pasados por parámetros
     * @param SUCSregistro1 Serán los números de sucs donde interviene el registro 1
     * @param SUCSregistro2 Serán los números de sucs donde interviene el registro 2
     * @return 
     * @throws Exceptions.NoRelationshipException 
     */
    public static ArrayList<String> getSUCRelationship(ArrayList<String> SUCSregistro1, ArrayList<String> SUCSregistro2) throws NoRelationshipException {
        ArrayList<String> solve = new ArrayList<>();
        String[] lineaSUC1 = null;
        String[] lineaSUC2 = null;
        for (int i = 0; i < SUCSregistro1.size(); i++) {
            lineaSUC1 = SUCSregistro1.get(i).split("-");
            for (int j = 0; j < SUCSregistro2.size(); j++) {
                lineaSUC2 = SUCSregistro2.get(j).split("-");
                if (lineaSUC1[0].equals(lineaSUC2[0])) {
                    solve.add(SUCSregistro1.get(i));
                }
            }
        }

        /**
         * ELIMINAMOS LOS Nº DE SUCS QUE PUEDAN ESTAR REPETIDOS, CONSIDERAREMOS REPETIDO SI NºSUC Y ESTADOS SON LOS MISMOS EN LA BUSQUEDA DE LA RELACIÓN.
         */
        if (solve.size() > 0) {
            ArrayList<String> copy = new ArrayList<>(solve);
            int index = 0;
            int indexCopy = 1;

            while (index < solve.size()) {
                String[] linea1 = solve.get(index).split("-");
                while (indexCopy < copy.size()) {
                    String[] linea2 = solve.get(indexCopy).split("-");
                    if (linea1[0].equals(linea2[0]) && linea1[1].equals(linea2[1])) {
                        //repetidos = true;
                        solve.remove(indexCopy);
                        //index = 0;
                        copy = new ArrayList<>(solve);
                    } else {
                        indexCopy++;
                    }

                }
                index++;
                indexCopy = index + 1;
            }

        }else throw new NoRelationshipException();
        
        return solve;
    }
    
    /***
     * Dado un ID y un miga, devuelve los nº de sucs donde ha sido solicitado, además del estado del nº de suc.
     * @param registros
     * @param idRegistro
     * @param miga
     * @return 
     */
    public static ArrayList<String> getSUCS(ArrayList<Registro> registros, String idRegistro, String miga){
        ArrayList<String> solve = new ArrayList<>(); //DEVUELVE STRINGS DE ESTE TIPO: 957XXXXX + ESTADO_SUC + CABLES
        int cableIndex;
        for (int i = 0; i < registros.size(); i++) {
            if(registros.get(i).getMiga().equals(miga) && registros.get(i).getIPIDID().equals(idRegistro)){
                //AHORA VAMOS A SEPARAR LOS CABLES POR BARRAS VERTICALES, PARA INTENTAR SACAR EL TRAMO QUE LOS UNE, EL Nº DE CABLES QUE VAN
                //ATENTO, SI TIENE USO SALIDA, EL PRIMER CABLE SERÁ EL DE LA SALIDA, Y EL SEGUNDO EL QUE VA POR EL CANALIZADO 'SIGUIENTE'
                String [] splitCable = registros.get(i).getCable().split("\\|\\|");
                if(registros.get(i).getUso().equals("S") && splitCable.length > 1){  //SI TIENE USO SALIDA, COGEREMOS EL DOS
                    cableIndex = 1;
                }else {
                    cableIndex = 0;
                }
                solve.add(registros.get(i).getNumeroSUC() + " - " + registros.get(i).getEstado() + " - " + splitCable[cableIndex]);                
            }
        }
        
        return solve;
    }
    
    /**
     * Devuelve falso si el registro no existe en el arraylist "registros".
     * @param registros
     * @param registro
     * @return Devuelve falso si el registro no existe en el arraylist.
     */
    public static boolean exist(ArrayList<Registro> registros, Registro registro){
        int i = 0;
        while(i < registros.size()){
            if(Registro.compare(registros.get(i), registro)){
                return true;
            }else i++;
        }
        return false;
    }
      
    /**
     * Devolverá el registro de la lista que tenga el ID y el miga indicado por parámetros
     * @param registros
     * @param miga
     * @param ipid
     * @return Devolverá el registro de la lista
     */
    public static Registro getRegistro(ArrayList<Registro> registros, String miga, String ipid){
        int i = 0;
        while(i < registros.size()){
            //Si miga y registros coinciden, devolvemos el Registro
            if(miga.equals(registros.get(i).getMiga()) && ipid.equals(registros.get(i).getIPIDID())){
                return registros.get(i);
            }else i++;
        }
        return null;
    }
    
    /**
     * Devuelve si se puede usar o no el solicitud A en un registro. Los estados serán:
     * @param registro
     * @return Devuelve 0 si no se puede usar, devuelve 1 si solo se usa empalme, devuelve 2 si se puede usar registro de entrada y devuelve 3 si se usan las dos cosas.
     * @throws SolicitudAException 
     */
    public static int canUseSolicitudA(Registro registro) throws SolicitudAException {
        if (registro.getEstado().replaceAll(" ", "").contains("ANULADA") || 
            registro.getEstado().replaceAll(" ", "").contains("BAJA") || 
            registro.getEstado().replaceAll(" ", "").contains("INVIABLE")) {
            throw new SolicitudAException("La SUC que pertenece al registro ha sido Anulada, dada de Baja o es Inviable.");
        } else {
            if (registro.getElementoPasivo().replaceAll(" ", "").length() > 4 && registro.getUso().replaceAll(" ", "").equals("E")) {
                return 3;
            } else if (registro.getElementoPasivo().length() > 4 || registro.getUso().equals("Emp")) {
                return 1;
            } else if (registro.getElementoPasivo().length() < 4 && registro.getUso().equals("E")) {
                return 2;
            } else {
                throw new SolicitudAException("No se ha solicitado ni empalme ni registro de entrada en el registro " + registro.getIPIDID());
            }
        }
        //SI NO ESTÁ EN ESTADO INCORRECTO, PASAMOS A VER SI CONTIENE ELEMENTO PASIVO O USO ENTRADA
     
    }
}
