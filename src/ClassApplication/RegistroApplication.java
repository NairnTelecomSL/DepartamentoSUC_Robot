/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassApplication;

import DataClass.Registro;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Álvaro Rofa Aranda
 */
public final class RegistroApplication {
    public RegistroApplication(){}
    
    /**
     * Lee el fichero CSV pasádo por parámetro
     * @param csvFile
     * @return 
     */
    public static ArrayList<Registro> readCSVData(String csvFile){
        BufferedReader br = null;
        ArrayList<Registro> registros = new ArrayList<>();
        int numFila = 1, REG = 0;
        try {
            br = new BufferedReader(new FileReader(csvFile));
            String line = br.readLine(), cable, elemento, ipid, identificacion, uso;
            line = br.readLine();
            while (line != null) {
                String[] fields = line.split(";");                
                /**
                 * EL VALOR DEL Nº SUC ES cell = fields[0] EL VALOR DEL MIGA ES
                 * cell = fields[1] EL VALOR DEL ESTADO ES cell = fields[5] EL
                 * VALOR DEL IDENTIFICADOR ES cell = fields[7] EL VALOR DEL USO
                 * ES cell = fields[10] EL VALOR DEL CABLE ES cell = fields[11]
                 * EL VALOR DEL ELEMENTO PASIVO ES cell = fields[12] EL VALOR
                 * DEL IPID_ID ES cell = fields[13]
                 */
                cable = "S/N"; elemento = "S/N"; ipid = "S/N" ; identificacion = "S/N"; uso = "S/N";
                //Registro(String numero_SUC, String miga, String estado, String identificador, String uso, String cable, String elementoPasivo, String ipid_id)
                if (csvFile.contains("W49")) {
                    identificacion = fields[9];
                    uso = fields[10];
                    switch (fields.length) {
                        case 14:
                            cable = fields[11];
                            elemento = fields[12];
                            ipid = fields[13];
                            break;
                        case 13:
                            cable = fields[11];
                            elemento = fields[12];
                            break;
                        case 12:
                            cable = fields[11];
                            break;
                        default:
                            break;
                    }
                }else{
                    //System.out.println("leemos fila " + (numFila++) + " El tamaño de la actual es " + fields.length);
                    //System.out.println("Añadimos de actual");
                    //System.out.println("Tamaño encontrado: " + fields.length);
                    switch (fields.length) {
                        case 16:
                            /**
                             * CUENTA CON TODOS LOS DATOS
                             */
                            uso = fields[10];
                            identificacion = fields[9];
                            cable = fields[11];
                            elemento = fields[14];
                            ipid = fields[15];
                            break;
                        case 12:
                             //SIN ID NI ELEMENTO PASIVO
                            uso = fields[10];
                            identificacion = fields[9];
                            cable = fields[11];
                            
                            break;
                        case 11:    
                             //SIN ID NI ELEMENTO PASIVO, SIN CABLE, SIN ID, SIN IDENTIFICACIÓN
                            uso = fields[9];
                            break;
                        default:
                            break;
                    }
                    ++REG;
                }                
                Registro newReg = new Registro(fields[0], fields[1], fields[5], identificacion, uso, cable, elemento, ipid);
                
                if(fields.length >= 11){
                    registros.add(newReg);
                    numFila++;
                }
                line = br.readLine();
            }            
        } catch (IOException e) {
            System.out.println("Ha surgido un error: " + e.getMessage() + ". En la fila " + numFila);
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException ex) {
                    System.out.println("Ha surgido un error: " + ex.getMessage() + ". En la fila " + numFila);
                }
            }
        } 
        System.out.println("Se han introducido un total de " + numFila + " en el robot " + csvFile);
        return registros;
    }
    
    /***
     * Devuelve los nº de suc que estén relacionados entre los dos registros pasados por parámetros
     * @param SUCSregistro1 Serán los números de sucs donde interviene el registro 1
     * @param SUCSregistro2 Serán los números de sucs donde interviene el registro 2
     * @return 
     */
    public static ArrayList<String> getSUCRelationship(ArrayList<String> SUCSregistro1, ArrayList<String> SUCSregistro2) throws Exception {
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

        }else throw new Exception("No existe relación entre registros. ");
        
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
        ArrayList<String> solve = new ArrayList<>(); //DEVUELVE STRINGS DE ESTE TIPO: 957XXXXX + ESTADO_SUC
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
     * Devolverá un arraylist con todos los registros encontrados en ambos ficheros, eliminando los registros duplicados que pueda haber en los dos ficheros.
     * @return 
     */
    public static ArrayList<Registro> readCSVData() {
        //PREVIAMENTE, LEEMOS EL FICHERO W49, DESPUES, INTRODUCIREMOS TANTOS REGISTROS DE ACTUAL COMO PODAMOS.
        ArrayList<Registro> registrosW49 = readCSVData("Files//Robot_Tesa_W49.csv");
        //System.out.println("Aniadimos " + registrosW49.size() + " registros de W49");
        ArrayList<Registro> registrosWAct = readCSVData("Files//actual.csv");
        //System.out.println("Aniadimos " + registrosWAct.size() + " registros de ACTUAL");
        ArrayList<Registro> registros = new ArrayList<>();
        registros.addAll(registrosW49);
        registros.addAll(registrosWAct);
        //System.out.println("En total " + registros.size() + " registros de las dos semanas.");
       
        return registros;
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
}
