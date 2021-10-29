/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassApplication;

import DataClass.Registro;
import Exceptions.NoFilesException;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class FileReader {
    /**
     * Lee el fichero CSV pasádo por parámetro
     * @param csvFile
     * @return 
     * @throws Exceptions.NoFilesException 
     */
    public static ArrayList<Registro> readCSVData(String csvFile) throws NoFilesException{
        BufferedReader br = null;
        ArrayList<Registro> registros = new ArrayList<>();
        int numFila = 1, REG = 0;
        try {
            br = new BufferedReader(new java.io.FileReader(csvFile));
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
            throw new NoFilesException();
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
    
    
    /**
     * Devolverá un arraylist con todos los registros encontrados en ambos ficheros, eliminando los registros duplicados que pueda haber en los dos ficheros.
     * @return 
     * @throws Exceptions.NoFilesException 
     */
    public static ArrayList<Registro> readCSVData()throws NoFilesException{
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
}
