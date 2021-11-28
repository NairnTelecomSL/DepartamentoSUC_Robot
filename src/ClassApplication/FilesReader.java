/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassApplication;

import Constantes.ConstData;
import DataClass.Centrales;
import DataClass.DataFile;
import DataClass.Registro;
import Exceptions.FicherosException;
import Exceptions.NoFilesException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

/**
 *
 * @author Álvaro Rofa Aranda
 */
public class FilesReader {
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
    public static ArrayList<Registro> readCSVData()throws NoFilesException, FicherosException{
        DataFile fUses = new DataFile();
       
        //PREVIAMENTE, LEEMOS EL FICHERO W49, DESPUES, INTRODUCIREMOS TANTOS REGISTROS DE ACTUAL COMO PODAMOS.
        ArrayList<Registro> registrosW49 = readCSVData(fUses.getRobotW49Route());
        //System.out.println("Aniadimos " + registrosW49.size() + " registros de W49");
        ArrayList<Registro> registrosWAct = readCSVData(fUses.getRobotWActRoute());
        //System.out.println("Aniadimos " + registrosWAct.size() + " registros de ACTUAL");
        ArrayList<Registro> registros = new ArrayList<>();
        registros.addAll(registrosW49);
        registros.addAll(registrosWAct);
        //System.out.println("En total " + registros.size() + " registros de las dos semanas.");
       
        return registros;
    }


    public static ArrayList<Centrales> readTesaMigaXLSX(){
        int num_Row = 1;
        int num_Column = 0;
        
        ArrayList<Centrales> arrayCentrales = new ArrayList<>();
       
        try {
            Workbook workbook;
            arrayCentrales = new ArrayList<>();
            File fileCentrales  = new File(ConstData.ROUTE_MIGA_FILE); 
            InputStream inp = new FileInputStream(fileCentrales);
            
            workbook = WorkbookFactory.create(inp);
            /*A continuación, debemos pasar los datos a la tabla.*/
            org.apache.poi.ss.usermodel.Sheet sheetAt = workbook.getSheetAt(0);

            num_Row = 1;
            num_Column = 0;
            Row row = sheetAt.getRow(num_Row);

            while (row != null) {
                
                
                String poblacion = row.getCell(0).getStringCellValue();
                String miga = NumberToTextConverter.toText(row.getCell(1).getNumericCellValue());
                String nombreCT = row.getCell(2).getStringCellValue();
                String provMun = NumberToTextConverter.toText(row.getCell(3).getNumericCellValue());
                String nombre = row.getCell(4).getStringCellValue().toUpperCase();
                
                arrayCentrales.add(new Centrales(poblacion, miga, nombreCT, provMun, nombre));
                row = sheetAt.getRow(++num_Row);
            }

        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error " + ex.getMessage() + "Ha ocurrido en la fila " + num_Row + " Columna " + num_Column);
        }
        
        return arrayCentrales;
    }
    
}
